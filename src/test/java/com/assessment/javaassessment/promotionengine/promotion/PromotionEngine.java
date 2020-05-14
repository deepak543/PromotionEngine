package com.assessment.javaassessment.promotionengine.promotion;

import com.assessment.javaassessment.promotionengine.model.CartItem;
import com.assessment.javaassessment.promotionengine.model.ItemSKU;
import com.assessment.javaassessment.promotionengine.service.ShoppingCart;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PromotionEngine {

    static Set<IPromotion> promotions = new HashSet<>();
    public static void createSingleSKUPromotion(int price, int quantity, ItemSKU itemSKU)
    {
        IPromotion promotion =  SingleSKUPromotion.builder()
                .itemSKU(itemSKU)
                .quantity(quantity)
                .price(price)
                .build();
        promotions.add(promotion);
    }

    public static void createMultipleSKUPromotion(int price, ItemSKU... itemSKUs)
    {
        IPromotion promotion = MultipleSKUPromotion.builder()
                .skuList(new HashSet<>(Arrays.asList(itemSKUs)))
                .price(price)
                .build();
        promotions.add(promotion);
    }

    public static int calculatePromotionPrice(CartItem cartItem)
    {
        for(IPromotion promotion : promotions)
        {
            if(promotion.appliesTo(cartItem))
                return promotion.calculatePrice(cartItem);
        }
        return -1;
    }



}
