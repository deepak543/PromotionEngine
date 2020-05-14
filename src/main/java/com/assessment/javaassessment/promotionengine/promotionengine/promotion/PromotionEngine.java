package com.assessment.javaassessment.promotionengine.promotionengine.promotion;

import com.assessment.javaassessment.promotionengine.promotionengine.model.CartItem;
import com.assessment.javaassessment.promotionengine.promotionengine.model.ItemSKU;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Promotion engine.
 */
@Getter
@Setter
public class PromotionEngine {

    /**
     * The Promotions.
     */
    static Set<IPromotion> promotions = new HashSet<>();

    /**
     * Create single sku promotion.
     *
     * @param price    the price
     * @param quantity the quantity
     * @param itemSKU  the item sku
     */
    public static void createSingleSKUPromotion(int price, int quantity, ItemSKU itemSKU)
    {
        IPromotion promotion =  SingleSKUPromotion.builder()
                .itemSKU(itemSKU)
                .quantity(quantity)
                .price(price)
                .build();
        promotions.add(promotion);
    }

    /**
     * Create multiple sku promotion.
     *
     * @param price    the price
     * @param itemSKUs the item sk us
     */
    public static void createMultipleSKUPromotion(int price, ItemSKU... itemSKUs)
    {
        IPromotion promotion = MultipleSKUPromotion.builder()
                .skuList(new HashSet<>(Arrays.asList(itemSKUs)))
                .price(price)
                .build();
        promotions.add(promotion);
    }

    /**
     * Calculate promotion price int.
     *
     * @param cartItem the cart item
     * @return the int
     */
    public static int calculatePromotionPrice(CartItem... cartItem)
    {
        for(IPromotion promotion : promotions)
        {
            if(promotion.appliesTo(cartItem)) {
                //cartItem.setProcessed(true);
                return promotion.calculatePrice(cartItem);
            }
        }
        return -1;
    }



}
