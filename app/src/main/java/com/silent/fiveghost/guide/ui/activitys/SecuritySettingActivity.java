package com.silent.fiveghost.guide.ui.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.ui.BaseActivity;

public class SecuritySettingActivity extends BaseActivity {

    private ImageView left_icon;
    private TextView mTitle;
    private ImageView mMessage;
    private TextView xiaoxitv_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_setting);
        initView();

    }

    private void initView() {
        left_icon = (ImageView) findViewById(R.id.left_icon);
        mTitle = (TextView) findViewById(R.id.mTitle);
        mMessage = (ImageView) findViewById(R.id.mMessage);
        xiaoxitv_num = (TextView) findViewById(R.id.xiaoxitv_num);
        left_icon.setBackgroundResource(R.mipmap.a);
        mTitle.setText("安全设置");
        mMessage.setVisibility(View.GONE);
        xiaoxitv_num.setVisibility(View.GONE);
        left_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SecuritySettingActivity.this.finish();;
            }
        });
    }
}
