package com.backendbigdata.controller;

import com.backendbigdata.dto.RestResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
    private static final Logger EMAIL_LOGGER = LoggerFactory.getLogger("emailLogger");

    /**
     * Creates a ResponseEntity to be sent back to client
     * @param restResponseDto holding the response object and HTTP status
     * @return ResponseEntity with HTTP status and response object
     */
    public static ResponseEntity<RestResponseDto> response(RestResponseDto restResponseDto) {
        return new ResponseEntity<>(restResponseDto, restResponseDto.getStatus());
    }

    /**
     * In case any exception occurs, use this method to send response with the exception
     * @param ex exception
     * @return ResponseEntity with HTTP status and response object
     */
    public static ResponseEntity<RestResponseDto> response(Throwable ex) {
        boolean continueLoop = true;
        int iteration = 0;
        StringBuilder err = new StringBuilder("Internal Server Error occurred[");
        Throwable e = ex;
        while (continueLoop) {
            err.append(ex.getMessage()).append("\n | ");
            ex = ex.getCause();

            iteration++;
            if (ex == null || iteration > 20)
                continueLoop = false;
        }
        err.append("]");

        LOGGER.error(err.toString(), e);
        EMAIL_LOGGER.error(err.toString(), e);
        RestResponseDto restResponseDto = new RestResponseDto();
        restResponseDto.makeInternalServerErrorResponse();
        return response(restResponseDto);

    }
}
