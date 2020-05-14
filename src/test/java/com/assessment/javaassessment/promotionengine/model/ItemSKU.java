package com.assessment.javaassessment.promotionengine.model;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ItemSKU {
    String SKU;
    int price;
}
