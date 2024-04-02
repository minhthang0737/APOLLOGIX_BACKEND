package com.test.skill.assessment.system.payload;

import com.test.skill.assessment.system.message.BaseMessage;
import com.test.skill.assessment.system.message.CommonMessage;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
public class BaseResponse<TData> {
    private String code;
    private String message;
    private TData data;


    public BaseResponse(String code, String message, TData data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <TData> BaseResponse<TData> success(TData data) {
        return new BaseResponse<>(CommonMessage.SUCCESS.getCode(), CommonMessage.SUCCESS.getMessage(), data);
    }

    public static <TData> BaseResponse<TData> failure(BaseMessage messageResponse) {
        return new BaseResponse<>(messageResponse.getCode(), messageResponse.getMessage(), null);
    }

    public static <TData> BaseResponse<TData> failure(String code, String message) {
        return new BaseResponse<>(code, message,null);
    }
    
    public void setData(TData tData) {
        this.data = tData;
    }

    public Boolean hadError() {
        return !CommonMessage.SUCCESS.getCode().equals(this.code);
    }
    
}