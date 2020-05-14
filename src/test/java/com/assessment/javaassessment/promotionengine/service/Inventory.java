package com.assessment.javaassessment.promotionengine.service;

import com.assessment.javaassessment.promotionengine.model.ItemSKU;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<ItemSKU> itemSKUList;

    public void setup(List<ItemSKU> itemSKUList) {
        this.itemSKUList = new ArrayList<>(itemSKUList);
    }

    public void addSKUItem(ItemSKU itemSKU)
    {
        this.itemSKUList.add(itemSKU);
    }

    public void removeSKUItem(ItemSKU itemSKU)
    {
        itemSKUList.remove(itemSKU);
    }
}
