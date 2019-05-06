package com.zheng.my.shop.commons.dto;

public class BaseResult {
    private int status;
    private String message;


    public static BaseResult success() {

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
