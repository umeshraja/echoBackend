package com.backendbigdata.service;

import com.backendbigdata.dto.RestResponseDto;
import com.backendbigdata.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    ChatRepository chatRepository;

    public RestResponseDto getMostActiveUser() {
        RestResponseDto restResponseDto = new RestResponseDto();
        restResponseDto.makeSuccessResponse(chatRepository.getMostActiveUser());
        return restResponseDto;
    }

    public RestResponseDto getLeastActiveUser() {
        RestResponseDto restResponseDto = new RestResponseDto();
        restResponseDto.makeSuccessResponse(chatRepository.getLeastActiveUser());
        return restResponseDto;
    }

    public RestResponseDto getMostActiveInitiator() {
        RestResponseDto restResponseDto = new RestResponseDto();
        restResponseDto.makeSuccessResponse(chatRepository.getMostActiveInitiator());
        return restResponseDto;
    }

    public RestResponseDto getMostActiveChatter() {
        RestResponseDto restResponseDto = new RestResponseDto();
        restResponseDto.makeSuccessResponse(chatRepository.getMostActiveChatter());
        return restResponseDto;
    }

    public RestResponseDto getMostActiveOppChatter() {
        RestResponseDto restResponseDto = new RestResponseDto();
        restResponseDto.makeSuccessResponse(chatRepository.getMostActiveOppChatter());
        return restResponseDto;
    }

    public RestResponseDto getMostActiveCaseChatter() {
        RestResponseDto restResponseDto = new RestResponseDto();
        restResponseDto.makeSuccessResponse(chatRepository.getMostActiveCaseChatter());
        return restResponseDto;
    }
}
