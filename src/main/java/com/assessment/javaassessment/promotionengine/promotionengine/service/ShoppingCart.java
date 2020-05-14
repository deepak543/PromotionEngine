package com.assessment.javaassessment.promotionengine.promotionengine.service;

import com.assessment.javaassessment.promotionengine.promotionengine.model.CartItem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


/**
 * The type Shopping cart.
 */
@Getter
@Setter
public class ShoppingCart {
    private Set<CartItem> cartItems = new HashSet<>();

    /**
     * Add cart item.
     *
     * @param cartItem the cart item
     */
    public void addCartItem(CartItem cartItem)
    {
        this.cartItems.add(cartItem);
    }

    /**
     * Remove cart item.
     *
     * @param cartItem the cart item
     */
    public void removeCartItem(CartItem cartItem)
    {
        this.cartItems.remove(cartItem);
    }
}
