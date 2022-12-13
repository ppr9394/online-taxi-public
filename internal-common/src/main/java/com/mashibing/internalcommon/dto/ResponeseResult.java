package com.mashibing.internalcommon.dto;

import com.mashibing.internalcommon.constant.CommonStatusEnum;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ResponeseResult<T>{

    private int code;
    private String message;
    private T data;

    /**
     * 成功
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponeseResult success(T data){
        return new ResponeseResult().setCode(CommonStatusEnum.SUCCESS.getCode()).setMessage(CommonStatusEnum.SUCCESS.getValue()).setData(data);
    }

    /**
     * 失败： 统一的失败
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResponeseResult fial(T data){
        return new ResponeseResult().setData(data);
    }
    /**
     * 失败: 自定义失败 错误码和提示信息
     * @param code
     * @param message
     * @return
     */
    public static ResponeseResult fail(int code, String message){
        return new ResponeseResult().setCode(code).setMessage(message);
    }

    /**
     * 失败：自定义失败，错误码，提示信息，具体错误信息
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static ResponeseResult fail(int code, String message, String data){
        return new ResponeseResult().setCode(code).setMessage(message).setData(data);
    }
}
