package com.yyl.mercury.Config.Exception;

import lombok.Data;

/**
 * @auther yyl
 * @date 2021/6/6 20:44
 */
@Data
public class BizException extends RuntimeException {
    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public BizException(){
        super();
    }

    public BizException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public BizException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
