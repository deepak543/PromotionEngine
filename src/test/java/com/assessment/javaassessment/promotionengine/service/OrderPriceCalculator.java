package com.assessment.javaassessment.promotionengine.service;

import com.assessment.javaassessment.promotionengine.model.CartItem;
import com.assessment.javaassessment.promotionengine.promotion.PromotionEngine;
import com.assessment.javaassessment.promotionengine.promotion.PromotionType;

public class OrderPriceCalculator {

    public void calculateTotalPrice(ShoppingCart shoppingCart)
    {
        int totalPrice = 0;
        for(CartItem cartItem : shoppingCart.getCartItems())
        {
           int itemPrice =  PromotionEngine.calculatePromotionPrice(cartItem);
           if(itemPrice == -1)
               itemPrice = cartItem.getItemSKU().getPrice() * cartItem.getQuantity();
           totalPrice += itemPrice;

        }
    }
}
