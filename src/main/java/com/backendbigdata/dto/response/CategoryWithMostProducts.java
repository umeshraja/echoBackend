package com.backendbigdata.dto.response;

import lombok.Data;

@Data
public class CategoryWithMostProducts {
    String name;
    Long numProducts;

    public CategoryWithMostProducts(String name, Long numProducts){
        this.name = name;
        this.numProducts = numProducts;
    }
}
