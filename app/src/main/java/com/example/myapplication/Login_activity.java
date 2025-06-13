package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Login_activity extends AppCompatActivity {
    TextView tvRegister;
    EditText edtUsername,edtPassword;
    Button btnLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tvRegister = findViewById(R.id.tvRegister);
        tvRegister.setOnClickListener(v -> {
            Intent intent = new Intent(Login_activity.this,SignUpActivity.class);
            startActivity(intent);
        });
        edtPassword = findViewById(R.id.etPassword);
        edtUsername = findViewById(R.id.etUsername);
        btnLogin = findViewById(R.id.btnLogin);

        checkloginWithDataFile();

    }
    //kiem tra account
    private  void checkloginWithDataFile(){
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (TextUtils.isEmpty(username)){
                    edtUsername.setError("Please enter username");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    edtPassword.setError("Please enter password");
                    return;
                }
                //read data in file user.txt
                try {
                    FileInputStream fileInput = openFileInput("user.txt");
                    int read =-1;
                    StringBuilder Builder = new StringBuilder();
                    while ((read = fileInput.read()) != -1){
                        Builder.append((char) read);
                        //lay toan bo du lieu trong file gan vao builder
                    }
                    fileInput.close();
                    String[] userAccount = Builder.toString().trim().split("\n");
                    boolean checkLogin = false;
                    for(int i = 0;i<userAccount.length;i++){
                        String user = userAccount[i].substring(0,userAccount[i].indexOf("|"));
                        String pass = userAccount[i].substring(userAccount[i].indexOf("|")+1);
                        if(username.equals(user) && password.equals(pass)){
                            checkLogin = true;
                            break;
                        }
                    }
                    if (checkLogin){
                        Toast.makeText(Login_activity.this,"Login successfully",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Login_activity.this,MenuActivity.class);
                        startActivity(intent);

                    }else {
                        Toast.makeText(Login_activity.this,"Login failed",Toast.LENGTH_SHORT).show();
                        return;
                    }


                }catch (FileNotFoundException e){

                }
                catch (Exception e){

                }

            }
        });

    }
}
