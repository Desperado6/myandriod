package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Left_Fragment leftFragment=new Left_Fragment();
        Right_Fragment rightFragment=new Right_Fragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction beginTransaction = fm.beginTransaction();
        beginTransaction.replace(R.id.left,leftFragment);
        beginTransaction.replace(R.id.right, rightFragment);
        beginTransaction.commit();


        Button button = (Button) findViewById(R.id.button);

        // 使用匿名内部类
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                                          //带返回值的跳转方法，参数1:intent意图
                                          // 参数二:请求码,是一个requestCode值，用于标识每个按钮所启动的activity
                                          startActivityForResult(intent, 1);

                                      }
                                  }                );
        Button button1 = (Button) findViewById(R.id.btn);
        // 使用匿名内部类
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast 显示事件
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("给她投票");
                final EditText et = new EditText(MainActivity.this);
                et.setHint("请输入票数");
                et.setSingleLine(true);
                builder.setView(et);
                builder.setNegativeButton
                        ("取消",null);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String password = et.getText().toString();
                        if (password.equals("2")) {
                            Toast.makeText(MainActivity.this, "投票成功", Toast.LENGTH_SHORT).show();
                        }else{  Toast.makeText(MainActivity.this, "投票失败。", Toast.LENGTH_SHORT).show();
                        }  }    });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1&&resultCode == 2){
            String acquiredData= data.getStringExtra("data"); //获取回传的数据
            Toast.makeText(MainActivity.this,acquiredData,Toast.LENGTH_SHORT).show();
        }
    }
}
