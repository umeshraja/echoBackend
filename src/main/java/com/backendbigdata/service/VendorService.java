package com.backendbigdata.service;

import com.backendbigdata.dto.ErrorDto;
import com.backendbigdata.dto.RestResponseDto;
import com.backendbigdata.dto.VendorWithMostProductsDto;
import com.backendbigdata.dto.constants.Error;
import com.backendbigdata.dto.response.HighPricedProductVendorDto;
import com.backendbigdata.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorService {

    @Autowired
    VendorRepository vendorRepository;

    public RestResponseDto getVendorWithMostProducts(Integer categoryId){
        RestResponseDto restResponseDto = new RestResponseDto();

        if(categoryId == null) {
            restResponseDto.makeFailureResponse(new ErrorDto(Error.REQUIRED_FIELDS_MISSING));
            return restResponseDto;
        }
        List<VendorWithMostProductsDto> vendorWithMostProductsDtos = vendorRepository.getVendorProducingMostProducts(categoryId);
        if(vendorWithMostProductsDtos.size() > 0)
        restResponseDto.makeSuccessResponse(vendorWithMostProductsDtos.get(0));
        return restResponseDto;
    }

    public RestResponseDto getHighPricedProductVendor(String cacit) {
        RestResponseDto restResponseDto = new RestResponseDto();

        if(cacit == null) {
            restResponseDto.makeFailureResponse(new ErrorDto(Error.REQUIRED_FIELDS_MISSING));
            return restResponseDto;
        }
        List<HighPricedProductVendorDto> vendorDtos = vendorRepository.getHighPricedProductVendor(cacit);
        if(vendorDtos.size() > 0)
            restResponseDto.makeSuccessResponse(vendorDtos.get(0));
        return restResponseDto;
    }

    public RestResponseDto getVendorsByProductCategory(Integer categoryId) {
        RestResponseDto restResponseDto = new RestResponseDto();

        restResponseDto.makeSuccessResponse(vendorRepository.getVendorsByProductsCategory(categoryId));

        return restResponseDto;
    }

    public RestResponseDto getAllVendors() {
        RestResponseDto restResponseDto = new RestResponseDto();

        restResponseDto.makeSuccessResponse(vendorRepository.findAll());

        return restResponseDto;
    }
}
