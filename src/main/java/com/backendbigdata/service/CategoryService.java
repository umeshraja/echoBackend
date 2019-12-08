package com.backendbigdata.service;

import com.backendbigdata.dto.ErrorDto;
import com.backendbigdata.dto.RestResponseDto;
import com.backendbigdata.dto.VendorWithMostProductsDto;
import com.backendbigdata.dto.constants.Error;
import com.backendbigdata.dto.response.CategoryResponseDto;
import com.backendbigdata.dto.response.CategoryWithMostProducts;
import com.backendbigdata.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public RestResponseDto getAllCategories(){
        RestResponseDto restResponseDto = new RestResponseDto<>();

        restResponseDto.makeSuccessResponse(categoryRepository.findAll());

        return restResponseDto;
    }

    public RestResponseDto getPriceStats(Integer categoryId){
        RestResponseDto restResponseDto = new RestResponseDto();

        restResponseDto.makeSuccessResponse(categoryRepository.getPriceStats(categoryId));

        return restResponseDto;
    }

    public RestResponseDto getCategoryWithMostProducts() {
        RestResponseDto restResponseDto = new RestResponseDto();

        List<CategoryWithMostProducts> categoryWithMostProducts = categoryRepository.getCategoryWithMostProducts();
        if(categoryWithMostProducts.size() > 0)
            restResponseDto.makeSuccessResponse(categoryWithMostProducts.get(0));
        return restResponseDto;
    }
}
