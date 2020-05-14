package com.assessment.javaassessment.promotionengine.promotion;

import com.assessment.javaassessment.promotionengine.model.CartItem;

public interface IPromotion {
    boolean appliesTo(CartItem... cartItem);
    int calculatePrice(CartItem... cartItem);
}
