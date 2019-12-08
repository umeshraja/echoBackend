package com.backendbigdata.service;

import com.backendbigdata.dto.RestResponseDto;
import com.backendbigdata.dto.response.PartDescription;
import com.backendbigdata.dto.response.ProductsByCategory;
import com.backendbigdata.repository.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService {

    @Autowired
    PartRepository partRepository;

    public RestResponseDto getPartAvgWeight(String cacit){
        RestResponseDto restResponseDto = new RestResponseDto();

        restResponseDto.makeSuccessResponse(partRepository.getPartAvgWeight(cacit));

        return restResponseDto;
    }

    public RestResponseDto getPricePerGram(String cacit) {
        RestResponseDto restResponseDto = new RestResponseDto();

        restResponseDto.makeSuccessResponse(partRepository.getPricePerGram(cacit));

        return restResponseDto;
    }

    public RestResponseDto getProductsByCountry(String countryId) {
        RestResponseDto restResponseDto = new RestResponseDto();

        restResponseDto.makeSuccessResponse(partRepository.getProductsByCountry(countryId));

        return restResponseDto;
    }

    public RestResponseDto getCountryWiseProductsCount() {
        RestResponseDto restResponseDto = new RestResponseDto();

        restResponseDto.makeSuccessResponse(partRepository.getCountryWiseProductsCount());

        return restResponseDto;
    }

    public RestResponseDto getPartsByCategory(Integer categoryId) {
        RestResponseDto restResponseDto = new RestResponseDto();

        List<PartDescription> partsDescriptionList = partRepository.getPartsByCategory(categoryId);

        restResponseDto.makeSuccessResponse(new ProductsByCategory(partsDescriptionList,partsDescriptionList.size()));

        return restResponseDto;
    }
}
