package com.test.skill.assessment.system.message;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CommonMessage implements BaseMessage {

    SUCCESS("000000", "Success."),
    BAD_REQUEST("000001", "Bad request."),
    SQL_HAD_ERROR("000002", "Sql exception."),
    UNAUTHORIZED("000005", "Unauthorized."),
    INTERNAL_SERVER_ERROR("999999", "Internal server error."),
    HAD_ERROR_THIRD_PARTY("000006", "Had error third party."),
    ACCESS_DENIED("000007", "Access Denied."),
    NO_DATA_FOUND("111111", "No data found!"),
    ;

    private final String code;
    private final String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
