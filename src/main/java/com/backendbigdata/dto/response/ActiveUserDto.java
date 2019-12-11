package com.backendbigdata.dto.response;

import lombok.Data;

@Data
public class ActiveUserDto {
    String userName;
    Integer numChatters;
    Integer numComments;
    Integer totalActivity;

    public ActiveUserDto(String userName, Integer numChatters, Integer numComments, Integer totalActivity) {
        this.userName = userName;
        this.numChatters = numChatters;
        this.numComments = numComments;
        this.totalActivity = totalActivity;
    }
}
