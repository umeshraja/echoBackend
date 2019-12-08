package com.backendbigdata.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class ProductsByCategory {
    List<PartDescription> partDetails;
    Integer numberOfItems;

    public ProductsByCategory(List<PartDescription> partDetails, Integer numberOfItems){
        this.partDetails = partDetails;
        this.numberOfItems = numberOfItems;
    }
}
