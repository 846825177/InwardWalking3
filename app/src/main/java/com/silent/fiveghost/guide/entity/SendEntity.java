package com.silent.fiveghost.guide.entity;

/**
 * Created by 农民伯伯 on 2018/1/29.
 */

public class SendEntity {

    /**
     * errcode : 1
     * errmsg : ok
     * data : true
     */

    private int errcode;
    private String errmsg;
    private boolean data;

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }
}
