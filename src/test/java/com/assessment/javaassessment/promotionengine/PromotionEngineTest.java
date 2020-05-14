package com.assessment.javaassessment.promotionengine;
import com.assessment.javaassessment.promotionengine.model.ItemSKU;
import com.assessment.javaassessment.promotionengine.service.Inventory;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
class PromotionEngineTest {

    @BeforeAll
    public void setUp()
    {
        List<ItemSKU> itemSKUList = new ArrayList<>();
        itemSKUList.add(ItemSKU.builder().SKU("A").price(50).build());
        itemSKUList.add(ItemSKU.builder().SKU("B").price(30).build());
        itemSKUList.add(ItemSKU.builder().SKU("C").price(20).build());
        itemSKUList.add(ItemSKU.builder().SKU("D").price(15).build());

        Inventory inventory = new Inventory();
        inventory.setup(itemSKUList);
    }

}