package com.silent.fiveghost.guide.ui.activitys;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.adapter.RouteAdapter;
import com.silent.fiveghost.guide.adapter.RouteDetailsAadapter;
import com.silent.fiveghost.guide.ui.BaseActivity;

public class RouteDetailsActivity extends BaseActivity {

    private XRecyclerView mRoute_details_recyclerview;
    private ImageView left_icon;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_details);
        initView();
    }

    private void initView() {
        mRoute_details_recyclerview = (XRecyclerView) findViewById(R.id.mRoute_details_recyclerview);
        mRoute_details_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        final RouteDetailsAadapter aadapter = new RouteDetailsAadapter(this);
        mRoute_details_recyclerview.setAdapter(aadapter);
        mRoute_details_recyclerview.addHeaderView(LayoutInflater.from(this).inflate(R.layout.rotedetails_recyclerheader, null));
        aadapter.setOnClickListener(new RouteAdapter.OnClickListener() {
            @Override
            public void onClick(int position) {
                showToast(position - mRoute_details_recyclerview.getHeaders_includingRefreshCount() + "");
            }
        });
        left_icon = (ImageView) findViewById(R.id.left_icon);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        left_icon.setBackgroundResource(R.mipmap.a);
        mTitle.setText("路线详情");
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num.setVisibility(View.GONE);
        left_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RouteDetailsActivity.this.finish();;
            }
        });
    }
}
