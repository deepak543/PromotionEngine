package com.assessment.javaassessment.promotionengine.promotionengine.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CartItem {
    boolean processed;
    int quantity;
    ItemSKU itemSKU;
    public void updateQuantity(int quantity)
    {
        this.quantity = quantity;
    }
}
