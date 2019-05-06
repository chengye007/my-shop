package com.zheng.my.shop.commons.dto;

public class BaseResult {

    public static final int STATUS_SUCCESS = 200;
    public static final int STATUS_FAIL = 500;

    private int status;
    private String message;


    /**
     * 创建成功信息对象
     * @return
     */
    public static BaseResult success() {
        return createBaseResult(STATUS_SUCCESS, "成功");
    }

    public static BaseResult success(String message) {
        return createBaseResult(STATUS_SUCCESS, message);
    }

    /**
     * 创建失败信息对象
     * @return
     */
    public static BaseResult fail() {
        return createBaseResult(STATUS_FAIL, "失败");
    }

    public static BaseResult fail(String message) {
        return createBaseResult(STATUS_FAIL, message);
    }

    public static BaseResult fail(int status, String message) {
        return createBaseResult(status, message);
    }



    /********* private function ***********/
    private static BaseResult createBaseResult(int status, String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(status);
        baseResult.setMessage(message);
        return baseResult;
    }

    /********* setter and getter ***********/
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
