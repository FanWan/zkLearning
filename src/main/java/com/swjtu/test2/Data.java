package com.swjtu.test2;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/**
 * Created by wanfan01 on 2018/8/8.
 */
public class Data implements Serializable {

    private static final long serialVersionUID = 1L;

    private String userName;

    private String userPass;

    public Data(String userPass, String userName) {
        this.userPass = userPass;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }


    @Override
    public String toString(){
        return "userName:" + userName + ", usesrPass:" + userPass;
    }


    public byte[] objectToByteArray(){

        return JSON.toJSONString(this).getBytes();
    }




}


