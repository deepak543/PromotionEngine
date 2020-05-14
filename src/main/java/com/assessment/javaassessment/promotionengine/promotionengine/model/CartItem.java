package com.assessment.javaassessment.promotionengine.promotionengine.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Cart item.
 */
@Builder
@Getter
@Setter
public class CartItem {
    /**
     * The Processed.
     */
    boolean processed;
    /**
     * The Quantity.
     */
    int quantity;
    /**
     * The Item sku.
     */
    ItemSKU itemSKU;

    /**
     * Update quantity.
     *
     * @param quantity the quantity
     */
    public void updateQuantity(int quantity)
    {
        this.quantity = quantity;
    }
}
