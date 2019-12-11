package com.backendbigdata.dto.response;

import lombok.Data;

@Data
public class ActiveInitiatorDto {
    String name;
    Integer initiationCount;

    public ActiveInitiatorDto(String name, Integer initiationCount) {
        this.name = name;
        this.initiationCount = initiationCount;
    }
}
