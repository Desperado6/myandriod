package com.example.enterandregist;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.DatabaseMetaData;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editXYH,editMiMa_1,editMiMa_2;
    private Button button;
    private ImageView returnImage;
    private TextView dengLu;
    private  MyDatabaseHelper dbHelper;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_register);
        init();
    }

    private void init() {
        editXYH=(EditText)findViewById(R.id.new_username);
        editMiMa_1=(EditText)findViewById(R.id.et_password_1);
        editMiMa_2=(EditText)findViewById(R.id.et_password_2);
        button=(Button) findViewById(R.id.bn_immediateRegistration);
        button.setOnClickListener(this);
        dengLu=(TextView)findViewById(R.id.tv_enter);
        dengLu.setOnClickListener(this);
        returnImage=(ImageView)findViewById(R.id.iv_return);
        returnImage.setOnClickListener(this);
        dbHelper=new MyDatabaseHelper(this,"Market",null,1);
        Button button2 =findViewById(R.id.button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.getWritableDatabase();
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bn_immediateRegistration:
                register();
                break;
            case R.id.tv_enter:
                returnEnter();
                break;
            case R.id.iv_return:
                returnEnter();
                break;
        }
    }

    private void register() {
        String username=editXYH.getText().toString().trim();
        String password_1=editMiMa_1.getText().toString().trim();
        String password_2=editMiMa_2.getText().toString().trim();
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else if(password_1.equals("")||password_2.equals("")){
            Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }else if(password_1.equals( password_2)==false){
            Toast.makeText(this, "两次密码不一致请重新输入！", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
            returnEnter();
        }
    }

    private void returnEnter() {
        Intent intent = new Intent(RegisterActivity.this, EnterActivity.class);  //进入主界面
        startActivity(intent);  //开始跳转
        finish();  //finish掉此界面
    }
}
