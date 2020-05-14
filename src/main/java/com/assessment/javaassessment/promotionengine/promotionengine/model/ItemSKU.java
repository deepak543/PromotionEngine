package com.assessment.javaassessment.promotionengine.promotionengine.model;

import lombok.Builder;
import lombok.Value;

/**
 * The type Item sku.
 */
@Builder
@Value
public class ItemSKU {
    String SKU;
    int price;
}
