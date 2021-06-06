package com.yyl.mercury.Config.ResultBody;

import com.yyl.mercury.Config.CommonEnum.ResultEnum;
import lombok.Data;

/**
 * 统一返回数据格式
 * @auther yyl
 * @date 2021/6/6 20:50
 */
@Data
public class ResultBody {
    /**
     * 响应代码
     */
    private String code;
    /**
     * 相应信息
     */
    private String msg;
    /**
     * 响应结果
     */
    private Object result;

    public ResultBody() {}

    public ResultBody(String resultType, String msg, Object data) {
        this.code = resultType;
        this.msg = msg;
        if (data != null) {
            result = data;
        }
    }

    /**
     * 成功
     * @return 结果
     */
    public static ResultBody success() {
        return success(null);
    }

    /**
     * 成功
     * @param data data
     * @return ResultBody
     */
    public static ResultBody success(Object data) {
        ResultBody resultBody = new ResultBody();
        resultBody.setCode(ResultEnum.SUCCESS.getCode());
        resultBody.setMsg(ResultEnum.SUCCESS.getMsg());
        resultBody.setResult(data);
        return resultBody;
    }

    /**
     * 错误
     * @return 错误
     */
    public static ResultBody error() {
        return error(null);
    }

    /**
     * 错误
     * @param msg 错误信息
     * @return
     */
    public static ResultBody error(String msg) {
        return error(msg, null);
    }

    /**
     * 错误
     * @param msg 错误信息
     * @param data 错误数据
     * @return
     */
    public static ResultBody error(String msg, Object data) {
        return new ResultBody(ResultEnum.FAILED.getCode(), msg, data);
    }
}
