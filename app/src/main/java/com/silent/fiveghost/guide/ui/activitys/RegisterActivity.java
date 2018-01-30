package com.silent.fiveghost.guide.ui.activitys;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.silent.fiveghost.guide.R;
import com.silent.fiveghost.guide.concat.Concat;
import com.silent.fiveghost.guide.entity.SendEntity;
import com.silent.fiveghost.guide.entity.SignupEntity;
import com.silent.fiveghost.guide.mvp.Iview;
import com.silent.fiveghost.guide.mvp.Presenters;
import com.silent.fiveghost.guide.tools.Tools;
import com.silent.fiveghost.guide.ui.BaseActivity;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private EditText mInsert_name;
    private EditText mInsert_phone;
    private EditText mInsert_yzm;
    private EditText mInsert_pwd;
    private EditText mYqm;
    private TextView getYzm;
    private Button mRegister_btn;
    private SendEntity s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }

    private void initView() {
        mInsert_name = (EditText) findViewById(R.id.register_mInsert_name);
        mInsert_phone = (EditText) findViewById(R.id.regiser_user_phone);
        mInsert_yzm = (EditText) findViewById(R.id.regiser_user_Yzm);
        mInsert_pwd = (EditText) findViewById(R.id.regisertuser_pwd);
        mYqm = (EditText) findViewById(R.id.regiser_mYqm);
        getYzm = (TextView) findViewById(R.id.regiser_getYzm);
        getYzm.setOnClickListener(this);
        mRegister_btn = (Button) findViewById(R.id.mRegister_btn);
        mRegister_btn.setOnClickListener(this);
    }




    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.regiser_getYzm:
               getyzm();
                break;
            case R.id.mRegister_btn:
                register();
                break;
        }
    }

    private void register() {
       /* if(s==null){
            Toast.makeText(this, "请获取验证码", Toast.LENGTH_SHORT).show();
            return;
        }*/
//        boolean data = s.getData();
        Presenters p = new Presenters(this,new Iview<SignupEntity>(){

            @Override
            public void success(SignupEntity signupentity) {
                if(signupentity.getErrcode()==1){
                    startActivity(LoginActivity.class);
                    finish();
                }else {
                    showToast(signupentity.getErrmsg());
                }
            }

            @Override
            public void failure(Throwable e) {
                showToast(e.toString());
            }
        });
        Map<String,String> mParams = new HashMap<>();
        mParams.put("tel",mInsert_phone.getText().toString());
        mParams.put("password",mInsert_pwd.getText().toString());
        mParams.put("category","1");
        mParams.put("code",mInsert_yzm.getText().toString());
        p.requestNews(Concat.SIGNUP,mParams);
//        17718341391   8898

    }

    private void getyzm() {
        Presenters p = new Presenters(RegisterActivity.this, new Iview<SendEntity>() {
            @Override
            public void success(SendEntity s) {
                RegisterActivity.this.s = s;
            }

            @Override
            public void failure(Throwable e) {
                Toast.makeText(RegisterActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        Map<String, String> mParams = new HashMap();
        String phone = mInsert_phone.getText().toString().trim();
        if(!Tools.isPhone(phone)) {
            showToast("请输入正确的手机号");
            return;
        }
        if (TextUtils.isEmpty(phone)) {
            Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
            return;
        }
        mParams.put("mobile", phone);
        mParams.put("module", "1");
        mParams.put("imei", Tools.getPhoneIMEI(this));
        p.requestNews(Concat.GERYZM_URL,mParams);
    }
}
