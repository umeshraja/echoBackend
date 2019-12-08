package com.backendbigdata.dto.response;

import lombok.Data;

@Data
public class HighPricedProductVendorDto {
    String name;
    Double avgPartPrice;

    public HighPricedProductVendorDto(String name, Double avgPartPrice){
        this.name = name;
        this.avgPartPrice = avgPartPrice;
    }
}
