package com.assessment.javaassessment.promotionengine.promotion;

import com.assessment.javaassessment.promotionengine.model.CartItem;
import com.assessment.javaassessment.promotionengine.model.ItemSKU;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
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
            if(!skuList.contains(item.getItemSKU()))
            {
                return false;
            }
            matches++;
        }
        return matches == cartItem.length;
    }

    @Override
    public int calculatePrice(CartItem... cartItem) {
        if(!appliesTo(cartItem))
            return -1;

        return price;
    }
}
