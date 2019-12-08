package com.backendbigdata.dto.response;

import lombok.Data;

@Data
public class PriceStatsDto {
    Double minPrice;
    Double maxPrice;
    Double avgPrice;

    public PriceStatsDto(Double minPrice, Double maxPrice, Double avgPrice){
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.avgPrice = avgPrice;
    }
}
