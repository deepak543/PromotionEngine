package com.assessment.javaassessment.promotionengine.promotion;

import com.assessment.javaassessment.promotionengine.model.ItemSKU;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PromotionEngine {

    Set<IPromotion> promotions = new HashSet<>();
    public void createSingleSKUPromotion(int price, int quantity, ItemSKU itemSKU)
    {
        IPromotion promotion =  SingleSKUPromotion.builder()
                .itemSKU(itemSKU)
                .quantity(quantity)
                .price(price)
                .build();
        promotions.add(promotion);
    }

    public void createMultipleSKUPromotion(int price, ItemSKU... itemSKUs)
    {
        IPromotion promotion = MultipleSKUPromotion.builder()
                .skuList(new HashSet<>(Arrays.asList(itemSKUs)))
                .price(price)
                .build();
        promotions.add(promotion);
    }


}
