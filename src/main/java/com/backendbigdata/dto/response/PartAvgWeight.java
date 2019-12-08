package com.backendbigdata.dto.response;

import lombok.Data;

@Data
public class PartAvgWeight {
    Double avgWeight;

    public PartAvgWeight(Double avgWeight){
        this.avgWeight = avgWeight;
    }
}
