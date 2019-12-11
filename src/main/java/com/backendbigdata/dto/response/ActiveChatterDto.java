package com.backendbigdata.dto.response;

import lombok.Data;

@Data
public class ActiveChatterDto {
    String chatterId;
    String chatterType;
    Integer chatterTypeId;
    String chatterName;
    Integer numOfComments;

    public ActiveChatterDto(String chatterId, String chatterType, Integer chatterTypeId, String chatterName, Integer numOfComments) {
        this.chatterId = chatterId;
        this.chatterType = chatterType;
        this.chatterTypeId = chatterTypeId;
        this.chatterName = chatterName;
        this.numOfComments = numOfComments;
    }
}
