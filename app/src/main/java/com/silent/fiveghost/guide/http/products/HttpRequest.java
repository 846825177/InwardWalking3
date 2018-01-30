package com.silent.fiveghost.guide.http.products;

import android.content.Context;

import com.silent.fiveghost.guide.http.HttpCallback;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @author 农民伯伯
 * @version 2017/10/31
 *          抽象工厂中的 抽象产品
 */

public interface HttpRequest<T> {
    void doGet(Context context, String path, Type type, HttpCallback<T> callback);

    void doPost(Context context, String path, Type type, Map<String, String> mParams, HttpCallback<T> callback);
}
