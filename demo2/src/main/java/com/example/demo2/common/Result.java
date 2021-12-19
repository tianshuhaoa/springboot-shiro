package com.example.demo2.common;

import java.io.Serializable;

/**
 * @author acosoft
 * @date 2019/11/5 0005
 * @description Result
 */
public class Result implements Serializable {


    /**
     * 成功返回码
     */
    public static final String RETURN_CODE_SUCC = "10000";

    /**
     * 失败返回码
     */
    public static final String RETURN_CODE_ERR = "10001";


    /**
     * 未登录返回码，一般接口调用会用到
     */
    public static final String RETURN_CODE_NOT_LOGIN = "10002";

    /**
     * 未关注公众号
     */
    public static final String RETURN_CODE_NOT_WECHAT_ACCOUNT = "10003";

    /**
     * 渠道编码为空
     */
    public static final String RETURN_CODE_CHANNEL_CODE_IS_EMPTY = "10004";

    /**
     * 渠道编码不存在
     */
    public static final String RETURN_CODE_CHANNEL_CODE_NOT_EXISTS = "10005";

    /**
     * 微信参数不存在
     */
    public static final String RETURN_CODE_PARAMS_NOT_EXISTS = "10006";

    /**
     * 微信传code为空
     */
    public static final String RETURN_CODE_WECHAT_CODE_IS_EMPTY = "10007";

    /**
     * 手机号码必填，去绑定手机号码页面
     */
    public static final String RETURN_CODE_BANDMOBILE = "10008";


    /**
     * 需要进行支付宝预授权
     */
    public static final String ALIPAY_APP_FREEZE = "10009";
    /**
     * 需要进行身份认证
     */
    public static final String RETURN_CODE_IDENTITY_AUTHENTICATION = "10010";
    /**
     * 需要进行驾驶证认证
     */
    public static final String RETURN_CODE_DRIVING_LICENSE_CERTIFICATION = "10011";

    /**
     * 订单无需确认返回码
     */
    public static final String RETURN_CODE_NO_SURE_ORDER = "20000";

    /**
     * 支付异常提示
     */
    public static final String WX_PAY_ERR = "80003";

    /**
     * 微信支付查询
     */
    public static final String RETURN_CODE_WXPAYSEARCH = "20006";


    /**
     * 微信支付余额不足
     */
    public static final String RETURN_CODE_WXNOTENOUGH = "20004";


    /**
     * 微信支付异常
     */
    public static final String RETURN_CODE_WXPAYERR = "20005";


    /**
     * 是否退款
     */
    public static final String IS_RETURN_MONEY = "30001";


    private Object data;
    private Object msg;
    private boolean success;
    private String code;

    public Result() {
    }

    public Result(Object msg, boolean success) {
        this.msg = msg;
        this.success = success;
    }

    public Result(Object data, Object msg, boolean success) {
        this.data = data;
        this.msg = msg;
        this.success = success;
    }

    public Result(Object data, Object msg, boolean success, String code) {
        this.data = data;
        this.msg = msg;
        this.success = success;
        this.code = code;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getMsg() {
        return this.msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static Result returnTrue(Object data) {
        Result r = new Result();
        r.setData(data);
        r.setSuccess(true);
        r.setCode("10000");
        return r;
    }

    public static Result returnTrue(Object data, Object msg) {
        Result r = new Result();
        r.setData(data);
        r.setMsg(msg);
        //成功10000，失败10001，用户未登录10002
        r.setCode("10000");
        r.setSuccess(true);
        return r;
    }

    public static Result returnFalse(Object msg) {
        Result r = new Result();
        r.setMsg(msg);
        r.setSuccess(false);
        r.setCode("10001");
        return r;
    }

    /**
     * token失效
     *
     * @param msg
     * @return
     */
    public static Result returnFalseByTokenExpire(Object msg) {
        Result r = new Result();
        r.setMsg(msg);
        r.setSuccess(false);
        r.setCode("99999");
        return r;
    }

    public static Result returnFalse(Object msg, Object data) {
        Result r = new Result();
        r.setMsg(msg);
        r.setData(data);
        r.setSuccess(false);
        r.setCode("10001");
        return r;
    }

    public static Result returnFalse(Object msg, Object data, String code) {
        Result r = new Result();
        r.setMsg(msg);
        r.setData(data);
        r.setCode(code);
        r.setSuccess(false);
        return r;
    }

    public static Result returnFalse(Object msg, String code) {
        Result r = new Result();
        r.setMsg(msg);
        r.setCode(code);
        r.setSuccess(false);
        return r;
    }


    public static boolean getResultState(String code) {
        if (RETURN_CODE_SUCC.equals(code)) {
            return true;
        } else {
            return false;
        }
    }
}