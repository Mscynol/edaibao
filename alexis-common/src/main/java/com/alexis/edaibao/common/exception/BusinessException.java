package com.alexis.edaibao.common.exception;

import com.alexis.edaibao.common.result.ResponseEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cc-zj
 * @create 2022-04-13 14:33
 * @apiNote 创建自定义异常(必须是运行时异常), 在程序中抛出这个自定义异常, 并在统一异常处理器中捕获自定义异常对象
 */
@Data
@NoArgsConstructor
public class BusinessException extends RuntimeException {
    /**
     * 异常错误码
     */
    private Integer code;
    /**
     * 异常描述信息
     */
    private String message;

    /**
     * @param message 错误消息
     */
    public BusinessException(String message) {
        this.message = message;
    }

    /**
     * @param message 错误消息
     * @param code    错误码
     */
    public BusinessException(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    /**
     * @param message 错误消息
     * @param code    错误码
     * @param cause   原始异常对象
     */
    public BusinessException(String message, Integer code, Throwable cause) {
        super(cause);
        this.message = message;
        this.code = code;
    }

    /**
     * @param resultCodeEnum 接收枚举类型
     */
    public BusinessException(ResponseEnum resultCodeEnum) {
        this.message = resultCodeEnum.getMessage();
        this.code = resultCodeEnum.getCode();
    }

    /**
     * @param resultCodeEnum 接收枚举类型
     * @param cause          原始异常对象
     */
    public BusinessException(ResponseEnum resultCodeEnum, Throwable cause) {
        super(cause);
        this.message = resultCodeEnum.getMessage();
        this.code = resultCodeEnum.getCode();
    }
}
