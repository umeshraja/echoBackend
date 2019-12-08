package com.backendbigdata.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;
import com.backendbigdata.dto.constants.Error;
import org.springframework.validation.Errors;

@Data
public class ErrorDto {

    @ApiModelProperty(value = "Unique identification of the error", required = true)
    private String errorCode;

    @ApiModelProperty(value = "detailed description of the error" ,required = true)
    private String errorMessage;

    @ApiModelProperty(value = "error statement" , required = true)
    private String errorDetails;

    public ErrorDto(Errors errors) {
        this.errorCode =  Integer.toString(HttpStatus.BAD_REQUEST.value());
        this.errorMessage = errors.getFieldError().getDefaultMessage();
        this.errorDetails = this.errorMessage;
    }


    public ErrorDto(String errorCode, String errorMessage, String errorDetails) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetails = errorDetails;
    }

    public ErrorDto(Error error) {
        this.errorCode = error.getCode();
        this.errorMessage = error.getMessage();
        this.errorDetails = error.getMessage();
    }

    public ErrorDto(Error error, String errorDetails) {
        this.errorCode = error.getCode();
        this.errorMessage = error.getMessage();
        this.errorDetails = errorDetails;
    }

    @Override
    public String toString() {
        return "ErrorDto [errorCode=" + errorCode + ", errorMessage=" + errorMessage + ", errorDetails=" + errorDetails + "]";
    }

}

