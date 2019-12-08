package com.backendbigdata.dto.response;

import lombok.Data;

@Data
public class CountryWiseProductsCount {
    String countryName;
    Long numProducts;

    public CountryWiseProductsCount(String countryName, Long numProducts){
        this.countryName = countryName;
        this.numProducts = numProducts;
    }
}
