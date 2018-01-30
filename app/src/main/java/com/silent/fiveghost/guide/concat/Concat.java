package com.silent.fiveghost.guide.concat;

/**
 * Created by 84682 on 2018/1/28.
 */

public interface Concat {
    //BASE_URL
    String BASE_URL ="http://120.79.137.110:81/api/v1/";



    //通用验证码接口
    String GERYZM_URL="sms/send";

    //注册
    String SIGNUP="auth/signup";

    //登录接口
    String LOGIN_URL="auth/login";

    //找回密码
    String AUTH_RESET_PASSWORD="auth/reset-password";

    //用户基本信息接口
    String USERINFO="user/info";

    String  FILE_NAME="user";
}
