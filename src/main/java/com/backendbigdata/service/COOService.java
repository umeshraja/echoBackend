package com.backendbigdata.service;

import com.backendbigdata.dto.RestResponseDto;
import com.backendbigdata.repository.COORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class COOService {

    @Autowired
    COORepository cooRepository;

    public RestResponseDto getAllCOO(){
        RestResponseDto restResponseDto = new RestResponseDto();

        restResponseDto.makeSuccessResponse(cooRepository.findAll());

        return restResponseDto;
    }
}
