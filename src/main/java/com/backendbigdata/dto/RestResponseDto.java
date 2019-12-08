package com.backendbigdata.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.slf4j.Logger;
import com.backendbigdata.dto.constants.Error;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.NoTransactionException;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class RestResponseDto<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LoggerFactory.getLogger(RestResponseDto.class);

    @JsonIgnore
    protected HttpStatus status = HttpStatus.OK; //HttpStatus.BAD_REQUEST

    @ApiModelProperty(value = "",required = true)
    protected T data;

    @ApiModelProperty(value = "",required = true)
    protected List<ErrorDto> errors = new ArrayList<>();

    @ApiModelProperty(value = "True if successful else false",required = true)
    protected boolean success;


    public RestResponseDto() {
        setSuccess(false);
    }

    public RestResponseDto<T> makeUnauthorizedResponse() {
        List<ErrorDto> errorList = new ArrayList<>();
        errorList.add(new ErrorDto(Error.AUTHENTICATION_ERROR));
        setErrors(errorList);
        setStatus(HttpStatus.OK); //HttpStatus.UNAUTHORIZED
        return this;
    }

    public RestResponseDto<T> makeInternalServerErrorResponse() {
        List<ErrorDto> errorList = new ArrayList<>();
        errorList.add(new ErrorDto(Error.INTERNAL_SERVER_ERROR));
        setErrors(errorList);
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        return this;
    }

    public RestResponseDto<T> makeBadRequestResponse() {
        setSuccess(false);
        setStatus(HttpStatus.BAD_REQUEST);
        return this;
    }

    public RestResponseDto<T> makeSuccessResponse() {
        this.makeSuccessResponse(HttpStatus.OK);
        return this;
    }

    public RestResponseDto<T> makeSuccessResponse(HttpStatus status) {
        setSuccess(true);
        setStatus(status);
        return this;
    }

    //TODO: directly return from all usages instead of creating new variables
    public RestResponseDto<T> makeSuccessResponse(T data) {
        this.makeSuccessResponse(data, HttpStatus.OK);
        return this;
    }

    public RestResponseDto<T> makeSuccessResponse(T data, HttpStatus status) {
        setSuccess(true);
        setStatus(status);
        setData(data);
        return this;
    }

    /**
     * By default rolls back transaction
     * @param error
     * @return
     */
    //TODO: directly return from all usages instead of creating new variables
    public RestResponseDto<T> makeFailureResponse(Error error) {
        makeFailureResponse(error, true);
        return this;
    }

    public RestResponseDto<T> makeFailureResponse(Error error, boolean rollbackTransaction) {
        makeFailureResponse(error, HttpStatus.OK, rollbackTransaction); // HttpStatus.BAD_REQUEST
        return this;
    }

    public RestResponseDto<T> makeFailureResponse(Error error, HttpStatus status, boolean rollbackTransaction) {

        List<ErrorDto> errorList = new ArrayList<>();
        errorList.add(new ErrorDto(error));
        setErrors(errorList);
        setStatus(status);
        setSuccess(Boolean.FALSE);

        if (rollbackTransaction) {
            try {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            } catch (NoTransactionException e) {
                // Ignore if no transaction was present
            } catch (Exception e) {
                LOGGER.error("Error while rolling back transaction", e);
            }
        }
        return this;
    }

    public RestResponseDto<T> makeFailureResponse(ErrorDto errorDto) {
        this.makeFailureResponse(errorDto, HttpStatus.OK); // HttpStatus.BAD_REQUEST
        return this;
    }

    public RestResponseDto<T> makeFailureResponse(ErrorDto errorDto, HttpStatus status) {
        List<ErrorDto> errorList = new ArrayList<>();
        errorList.add(errorDto);
        setErrors(errorList);
        setStatus(status);
        setSuccess(Boolean.FALSE);
        return this;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void addErrors(Error error) {
        errors.add(new ErrorDto(error));
    }

    public void addError(Error error, String details) {
        errors.add(new ErrorDto(error, details));
    }

    private void setSuccess(boolean success) {
        this.success = success;
    }

}
