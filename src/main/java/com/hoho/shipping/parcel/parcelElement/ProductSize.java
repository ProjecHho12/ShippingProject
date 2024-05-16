package com.hoho.shipping.parcel.parcelElement;

import java.util.Arrays;
import java.util.List;

public enum ProductSize {

    SMALL ("3,000원", Arrays.asList("소", "소형", "SMALL")),
    MEDIUM ("5,000원", Arrays.asList("중", "중형", "MEDIUM")),
    LARGE ("10,000원", Arrays.asList("대", "대형", "LARGE")),
    EXTRALARGE ("100,000원", Arrays.asList("특대", "특대형","EXTRALARGE"));

    String value;
    private final List<String> sizeName;

    ProductSize(String value, List<String> sizeName) {
        this.value = value;
        this.sizeName = sizeName;
    }

    public List<String> getSizeName() {
        return sizeName;
    }

    public String getValue() {
        return value;
    }
}