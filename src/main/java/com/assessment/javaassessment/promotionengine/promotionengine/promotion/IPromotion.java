package com.assessment.javaassessment.promotionengine.promotionengine.promotion;

import com.assessment.javaassessment.promotionengine.promotionengine.model.CartItem;

/**
 * The interface Promotion.
 */
public interface IPromotion {
    /**
     * Applies to boolean.
     *
     * @param cartItem the cart item
     * @return the boolean
     */
    boolean appliesTo(CartItem... cartItem);

    /**
     * Calculate price int.
     *
     * @param cartItem the cart item
     * @return the int
     */
    int calculatePrice(CartItem... cartItem);
}
