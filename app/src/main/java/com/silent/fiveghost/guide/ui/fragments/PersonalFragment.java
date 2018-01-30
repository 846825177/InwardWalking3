package com.silent.fiveghost.guide.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.PersonalAdapte;
import com.silent.fiveghost.guide.concat.Concat;
import com.silent.fiveghost.guide.mvp.Iview;
import com.silent.fiveghost.guide.mvp.Presenters;
import com.silent.fiveghost.guide.tools.SPTools;
import com.silent.fiveghost.guide.ui.activitys.MyRouteActivity;
import com.silent.fiveghost.guide.ui.activitys.SecuritySettingActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 84682 on 2018/1/27.
 */

public class PersonalFragment extends Fragment implements View.OnClickListener {

    private RecyclerView mPersion_recyc;
    private AutoRelativeLayout anquanshezhi;
    private AutoRelativeLayout wodeluxian;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.persion_al, container, false);
        Presenters p   = new Presenters(getActivity(), new Iview<String>() {
            @Override
            public void success(String s) {
                Log.e("TAG",s);
            }

            @Override
            public void failure(Throwable e) {

            }
        });
        //_za8e8fMg-ueDPbvVeZCBDWrFCrabPa-
        Map<String,String> mParams= new HashMap<>();
        SharedPreferences preferences = getActivity().getSharedPreferences(Concat.FILE_NAME, Context.MODE_PRIVATE);
        mParams.put("access_token",preferences.getString("access_token",null) );
        p.requestNews(Concat.USERINFO,mParams);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mPersion_recyc = (RecyclerView) view.findViewById(R.id.mPersion_recyc);
        mPersion_recyc.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));
        PersonalAdapte adapter = new PersonalAdapte(getActivity());
        mPersion_recyc.setAdapter(adapter);
        adapter.setOnClickListener(new PersonalAdapte.OnClickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        anquanshezhi = (AutoRelativeLayout) view.findViewById(R.id.anquanshezhi);
        anquanshezhi.setOnClickListener(this);
        wodeluxian = (AutoRelativeLayout) view.findViewById(R.id.wodeluxian);
        wodeluxian.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.anquanshezhi:
                startActivity(new Intent(getActivity(), SecuritySettingActivity.class));
                break;
            case R.id.wodeluxian:
                startActivity(new Intent(getActivity(), MyRouteActivity.class));
                break;
        }
    }
}
