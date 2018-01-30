package com.silent.fiveghost.guide.mvp;

import android.content.Context;

import java.util.Map;

/**
 * @author 农民伯伯
 * @version 2017/11/2
 */

public class Presenters {
    private Iview iview;
    private Models models;
    private Context context;

    public Presenters(Context context, Iview iview) {
        this.iview = iview;
        models = new ModelsImp();
        this.context=context;
    }

    public void requestNews(String url) {
        models.getRequest(context, url, iview);
    }
    public void requestNews(String url, Map<String,String> mParams) {
        models.postRequest(context,url,iview,mParams);
    }

}
