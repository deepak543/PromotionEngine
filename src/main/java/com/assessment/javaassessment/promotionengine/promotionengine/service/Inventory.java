package com.assessment.javaassessment.promotionengine.promotionengine.service;

import com.assessment.javaassessment.promotionengine.promotionengine.model.ItemSKU;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Inventory.
 */
public class Inventory {
    /**
     * The Item sku list.
     */
    List<ItemSKU> itemSKUList;

    /**
     * Sets .
     *
     * @param itemSKUList the item sku list
     */
    public void setup(List<ItemSKU> itemSKUList) {
        this.itemSKUList = new ArrayList<>(itemSKUList);
    }

    /**
     * Add sku item.
     *
     * @param itemSKU the item sku
     */
    public void addSKUItem(ItemSKU itemSKU)
    {
        this.itemSKUList.add(itemSKU);
    }

    /**
     * Remove sku item.
     *
     * @param itemSKU the item sku
     */
    public void removeSKUItem(ItemSKU itemSKU)
    {
        itemSKUList.remove(itemSKU);
    }
}
