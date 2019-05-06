package com.zheng.my.shop.commons.dto;

public class BaseResult {
    private int status;
    private String message;


    public static BaseResult success() {
        return createBaseResult(200, "成功");
    }

    public static BaseResult faild() {
        return createBaseResult(500, "失败");
    }




    /********* private function ***********/
    private static BaseResult createBaseResult(int status, String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.setStatus(500);
        baseResult.setMessage("失败");
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
