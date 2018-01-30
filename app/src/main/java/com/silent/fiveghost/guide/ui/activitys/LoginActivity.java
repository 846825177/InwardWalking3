package com.silent.fiveghost.guide.ui.activitys;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.concat.Concat;
import com.silent.fiveghost.guide.entity.LoginEntity;
import com.silent.fiveghost.guide.mvp.Iview;
import com.silent.fiveghost.guide.mvp.Presenters;
import com.silent.fiveghost.guide.ui.BaseActivity;
import com.zhy.autolayout.AutoRelativeLayout;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity implements Iview<LoginEntity>, View.OnClickListener {

    private Button mLogin;
    private Button mRegister;
    private TextView find_pdw;
    private Presenters presenters;
    private EditText mLogin_user;
    private EditText mLogin_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenters = new Presenters(LoginActivity.this, LoginActivity.this);
        initView();
    }

    private void initView() {
        mLogin = (Button) findViewById(R.id.mLogin_login);
        mRegister = (Button) findViewById(R.id.mLogin_Register);
        find_pdw = (TextView) findViewById(R.id.mLogin_find_pdw);
        mLogin.setOnClickListener(this);
        mRegister.setOnClickListener(this);
        find_pdw.setOnClickListener(this);
        mLogin_user = (EditText) findViewById(R.id.mLogin_user);
        mLogin_pwd = (EditText) findViewById(R.id.mLogin_pwd);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mLogin_login:
                Map<String, String> mParams = new HashMap<>();
                mParams.put("tel", mLogin_user.getText().toString());
                mParams.put("password", mLogin_pwd.getText().toString());
                presenters.requestNews(Concat.LOGIN_URL, mParams);
                break;
            case R.id.mLogin_Register:
                startActivity(new Intent(this, RegisterActivity.class));
                break;
            case R.id.mLogin_find_pdw:
                startActivity(new Intent(this, FindPwdActivity.class));
                break;
        }
    }


    @Override
    public void success(LoginEntity loginEntity) {
        if (loginEntity.getErrcode() == 1) {

            SharedPreferences preferences = getSharedPreferences(Concat.FILE_NAME, MODE_PRIVATE);
            SharedPreferences.Editor edit = preferences.edit();
            edit.putString("access_token", loginEntity.getData().getUser().getAccess_token());
            edit.commit();
            startActivity(InwardWalkingActivity.class);
        }
    }

    @Override
    public void failure(Throwable e) {

    }

    private void submit() {
        // validate
        String user = mLogin_user.getText().toString().trim();
        if (TextUtils.isEmpty(user)) {
            Toast.makeText(this, "user不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String pwd = mLogin_pwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            Toast.makeText(this, "pwd不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
