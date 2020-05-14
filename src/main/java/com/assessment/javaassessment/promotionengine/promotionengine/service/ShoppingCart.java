package com.assessment.javaassessment.promotionengine.promotionengine.service;

import com.assessment.javaassessment.promotionengine.promotionengine.model.CartItem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
public class ShoppingCart {
    private Set<CartItem> cartItems = new HashSet<>();

    public void addCartItem(CartItem cartItem)
    {
        this.cartItems.add(cartItem);
    }

    public void removeCartItem(CartItem cartItem)
    {
        this.cartItems.remove(cartItem);
    }
}
