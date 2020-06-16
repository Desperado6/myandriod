package com.example.enterandregist;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.PrecomputedText;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EnterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editYongHuMing,editMiMa;
    private TextView zhuCe;
    private Button btn;
    private String currentUsername,currentPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_enter);
        init();
    }
    private void init(){
        btn=findViewById(R.id.bn_common_login);
        btn.setOnClickListener(this);
        editYongHuMing=(EditText)findViewById(R.id.et_username);
        editMiMa=(EditText)findViewById(R.id.et_password);
        zhuCe=(TextView)findViewById(R.id.tv_register);
        zhuCe.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bn_common_login:
                login();
                break;
            case  R.id.tv_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void login() {
        currentUsername = editYongHuMing.getText().toString().trim(); //去除空格
        currentPassword = editMiMa.getText().toString().trim();
        if(TextUtils.isEmpty(currentUsername)){
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else if(TextUtils.isEmpty(currentPassword)){
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else{
            Intent intent = new Intent(EnterActivity.this, MainActivity.class);  //进入主界面
            startActivity(intent);  //开始跳转
            finish();  //finish掉此界面
        }

    }
}
