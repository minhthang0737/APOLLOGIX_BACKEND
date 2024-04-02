package com.test.skill.assessment.system.message;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BusinessMessage implements BaseMessage {
    ;
	
    private static final String PREFIX_ERROR = "105";
    private final String code;
    private final String message;
    
    @Override
    public String getCode() {
        return PREFIX_ERROR + this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

}
