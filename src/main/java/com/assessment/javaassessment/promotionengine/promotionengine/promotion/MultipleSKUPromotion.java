package com.assessment.javaassessment.promotionengine.promotionengine.promotion;

import com.assessment.javaassessment.promotionengine.promotionengine.model.CartItem;
import com.assessment.javaassessment.promotionengine.promotionengine.model.ItemSKU;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Builder
@Getter
@Setter
public class MultipleSKUPromotion implements IPromotion{
    Set<ItemSKU> skuList;
    int price;

    @Override
    public boolean appliesTo(CartItem... cartItem) {

        int matches = 0;
        for(CartItem item : cartItem)
        {
            if(skuList.contains(item.getItemSKU()))
            {
                matches++;
            }

        }
        return matches == skuList.size();
    }

    @Override
    public int calculatePrice(CartItem... cartItem) {
        if(!appliesTo(cartItem))
            return -1;
        int itemPrice = 0;
        for(CartItem item : cartItem)
        {
            if(!skuList.contains(item.getItemSKU()))
            {
                itemPrice += item.getItemSKU().getPrice() * item.getQuantity();
            }

        }
        return price + itemPrice;
    }
}
