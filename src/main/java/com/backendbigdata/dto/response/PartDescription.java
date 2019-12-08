package com.backendbigdata.dto.response;

import lombok.Data;

@Data
public class PartDescription {
    String partId;
    String description;

    public PartDescription(String partId, String description){
        this.partId = partId;
        this.description = description;
    }

}
