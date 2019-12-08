package com.backendbigdata.dto;

import lombok.Data;

@Data
public class VendorWithMostProductsDto {

    String name;
    Long productCount;

    public VendorWithMostProductsDto(String name, Long productCount){
        this.name = name;
        this.productCount = productCount;
    }

}
