package com.silent.fiveghost.guide.ui.activitys;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.MyRouteAadapter;
import com.silent.fiveghost.guide.ui.BaseActivity;

public class MyRouteActivity extends BaseActivity {

    private ImageView left_icon;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;
    private RecyclerView mRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_route);
        initView();
    }

    private void initView() {
        left_icon = (ImageView) findViewById(R.id.left_icon);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        left_icon.setBackgroundResource(R.mipmap.a);
        mTitle.setText("我的路线");
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num.setVisibility(View.GONE);
        left_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyRouteActivity.this.finish();
                ;
            }
        });
        mRecycler = (RecyclerView) findViewById(R.id.mRecycler);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
        MyRouteAadapter aadapter = new MyRouteAadapter(this);
        mRecycler.setAdapter(aadapter);
    }
}
