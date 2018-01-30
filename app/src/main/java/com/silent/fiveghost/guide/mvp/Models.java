package com.silent.fiveghost.guide.mvp;

import android.content.Context;

import com.silent.fiveghost.guide.http.HttpCallback;

import java.util.Map;

/**
 * @author 农民伯伯
 * @version 2017/11/2
 */

public interface Models {
    public void getRequest(Context context, String url, HttpCallback callback);

    public void postRequest(Context context, String url, HttpCallback callback, Map<String, String> mParams);
}
