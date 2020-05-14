package com.assessment.javaassessment.promotionengine;
import com.assessment.javaassessment.promotionengine.model.CartItem;
import com.assessment.javaassessment.promotionengine.model.ItemSKU;
import com.assessment.javaassessment.promotionengine.promotion.IPromotion;
import com.assessment.javaassessment.promotionengine.promotion.MultipleSKUPromotion;
import com.assessment.javaassessment.promotionengine.promotion.SingleSKUPromotion;
import com.assessment.javaassessment.promotionengine.service.Inventory;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
class PromotionEngineTest {

    @BeforeAll
    public static void setUp()
    {
        List<ItemSKU> itemSKUList = new ArrayList<>();
        itemSKUList.add(ItemSKU.builder().SKU("A").price(50).build());
        itemSKUList.add(ItemSKU.builder().SKU("B").price(30).build());
        itemSKUList.add(ItemSKU.builder().SKU("C").price(20).build());
        itemSKUList.add(ItemSKU.builder().SKU("D").price(15).build());

        Inventory inventory = new Inventory();
        inventory.setup(itemSKUList);
    }

    @Test
    public void cartItemTest()
    {
        CartItem cartItem = CartItem.builder().itemSKU(ItemSKU.builder().price(50).SKU("A").build()).quantity(2).build();
        assertThat(cartItem.getItemSKU().getSKU(), Is.is("A"));
        assertThat(cartItem.getQuantity(), Is.is(2));
        assertThat(cartItem.getItemSKU().getPrice(), Is.is(50));
    }

    @Test
    public void singleSKUPromotionAppliesToTest()
    {
        IPromotion promotion =  SingleSKUPromotion.builder()
                .itemSKU(ItemSKU.builder().SKU("A").price(50).build())
                .quantity(3)
                .price(150)
                .build();

        CartItem cartItem = CartItem.builder()
                .itemSKU(ItemSKU.builder()
                        .price(50)
                        .SKU("A")
                        .build())
                .quantity(5)
                .build();
        assertTrue(promotion.appliesTo(cartItem));
    }

    @Test
    public void singleSKUPromotionPriceTest()
    {
        IPromotion promotion =  SingleSKUPromotion.builder()
                .itemSKU(ItemSKU.builder().SKU("A").price(50).build())
                .quantity(3)
                .price(130)
                .build();

        CartItem cartItem = CartItem.builder()
                .itemSKU(ItemSKU.builder()
                        .price(50)
                        .SKU("A")
                        .build())
                .quantity(5)
                .build();
        assertEquals(230, promotion.calculatePrice(cartItem));
    }

    @Test
    public void multipleSKUPromotionPriceTest()
    {
        Set<ItemSKU> itemSKUSet = new HashSet<>();
        itemSKUSet.add(ItemSKU.builder().SKU("C").price(20).build());
        itemSKUSet.add(ItemSKU.builder().SKU("D").price(15).build());
        IPromotion promotion =  MultipleSKUPromotion.builder()
                .skuList(itemSKUSet)
                .price(30)
                .build();

        CartItem cartItem = CartItem.builder()
                .itemSKU(ItemSKU.builder()
                        .price(20)
                        .SKU("C")
                        .build())
                .quantity(1)
                .build();
        CartItem cartItem1 = CartItem.builder()
                .itemSKU(ItemSKU.builder()
                        .price(15)
                        .SKU("D")
                        .build())
                .quantity(1)
                .build();
        assertEquals(30, promotion.calculatePrice(cartItem, cartItem1));
    }

}