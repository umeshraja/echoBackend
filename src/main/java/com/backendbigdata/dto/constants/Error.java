package com.backendbigdata.dto.constants;

public enum Error {

    AUTHENTICATION_ERROR("MUN-0001", "Invalid access token"),
    INTERNAL_SERVER_ERROR("MUN-0002", "Something wrong happened with the application. Please try again later"),
    REQUIRED_FIELDS_MISSING("MUN-003", "Required fields are missing");

    private final String code;
    private final String message;

    Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}