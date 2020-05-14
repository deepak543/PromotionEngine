package com.assessment.javaassessment.promotionengine.service;

import com.assessment.javaassessment.promotionengine.model.CartItem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
public class ShoppingCart {
    private Set<CartItem> cartItems;

    public void addCartItem(CartItem cartItem)
    {
        this.cartItems.add(cartItem);
    }

    public void removeCartItem(CartItem cartItem)
    {
        this.cartItems.remove(cartItem);
    }
}
