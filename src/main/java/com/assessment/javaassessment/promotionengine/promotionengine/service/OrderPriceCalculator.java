package com.assessment.javaassessment.promotionengine.promotionengine.service;

import com.assessment.javaassessment.promotionengine.promotionengine.model.CartItem;
import com.assessment.javaassessment.promotionengine.promotionengine.promotion.PromotionEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Order price calculator.
 */
public class OrderPriceCalculator {

    /**
     * Calculate total price int.
     *
     * @param shoppingCart the shopping cart
     * @return the int
     */
    public int  calculateTotalPrice(ShoppingCart shoppingCart)
    {
        int totalPrice = 0;
        List<CartItem> unprocessedCartItems = new ArrayList<>();
        for(CartItem cartItem : shoppingCart.getCartItems())
        {
           int itemPrice =  PromotionEngine.calculatePromotionPrice(cartItem);
           if(itemPrice != -1)
               totalPrice += itemPrice;
           else
               unprocessedCartItems.add(cartItem);
        }
        int remainingPrice = PromotionEngine.calculatePromotionPrice(unprocessedCartItems.toArray(new CartItem[unprocessedCartItems.size()]));
        System.out.print(totalPrice + remainingPrice);
        return totalPrice + remainingPrice;
    }
}
