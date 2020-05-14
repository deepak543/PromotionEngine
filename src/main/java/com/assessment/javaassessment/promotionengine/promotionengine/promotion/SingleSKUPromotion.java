package com.assessment.javaassessment.promotionengine.promotionengine.promotion;

import com.assessment.javaassessment.promotionengine.promotionengine.model.CartItem;
import com.assessment.javaassessment.promotionengine.promotionengine.model.ItemSKU;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SingleSKUPromotion implements IPromotion{
    ItemSKU itemSKU;
    int quantity;
    int price;
    @Override
    public boolean appliesTo(CartItem... cartItem) {

        return cartItem[0].getItemSKU().getSKU().equals(this.itemSKU.getSKU())
                && cartItem[0].getQuantity() >= this.quantity;

    }

    @Override
    public int calculatePrice(CartItem... cartItem) {
        if(!appliesTo(cartItem))
            return -1;
        int discountedPrice = price + ((cartItem[0].getQuantity() - this.quantity) * cartItem[0].getItemSKU().getPrice());
        return discountedPrice;
    }
}
