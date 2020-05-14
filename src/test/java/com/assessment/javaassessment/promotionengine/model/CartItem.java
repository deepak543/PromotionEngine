package com.assessment.javaassessment.promotionengine.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Builder
@Getter
@Setter
public class CartItem {
    int quantity;
    ItemSKU itemSKU;
    public void updateQuantity(int quantity)
    {
        this.quantity = quantity;
    }
}
