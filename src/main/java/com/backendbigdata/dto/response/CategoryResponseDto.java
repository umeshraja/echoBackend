package com.backendbigdata.dto.response;

import com.backendbigdata.model.Category;
import lombok.Data;

@Data
public class CategoryResponseDto {

    Integer cId;
    String name;

    public CategoryResponseDto(Category category){
        this.cId = category.getCId();
        this.name = category.getName();
    }
}
