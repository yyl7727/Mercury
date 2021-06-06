package com.yyl.mercury.Config.CommonEnum;

public enum ResultEnum {
    /**
     * 成功
     */
    SUCCESS("200", "操作成功"),
    /**
     * 失败
     */
    FAILED("500", "操作失败");

    private final String code;

    private final String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() { return code; }

    public String getMsg() { return msg; }
}
