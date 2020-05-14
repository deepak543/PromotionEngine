package com.assessment.javaassessment.promotionengine.promotionengine.promotion;

import com.assessment.javaassessment.promotionengine.promotionengine.model.CartItem;

public interface IPromotion {
    boolean appliesTo(CartItem... cartItem);
    int calculatePrice(CartItem... cartItem);
}
