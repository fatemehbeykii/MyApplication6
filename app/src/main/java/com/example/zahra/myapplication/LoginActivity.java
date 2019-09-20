package com.example.zahra.myapplication;
import android.app.ProgressDialog;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLDecoder;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    EditText USER;
    EditText PASS;
    Button btn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        USER=findViewById(R.id.input_email);
        PASS=findViewById(R.id.input_password);
        btn= findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(USER.getText().toString().equals("admin")&&PASS.getText().toString().equals("admin")){
                    Intent intent= new Intent(LoginActivity.this,CurrentLocation.class);
                    intent.putExtra("location",40.7076519);
                    startActivity(intent);
                    fileList();
                }else{
                    Toast.makeText(getApplicationContext(), "نام کاربری یا رمز عبور اشتباه است :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
