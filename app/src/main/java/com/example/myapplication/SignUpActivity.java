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

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class SignUpActivity  extends AppCompatActivity {
    EditText edtUserName,edtPassword;
    String userName,password;
    Button btnRegister,btnLogin;
    TextView tvLogin;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitvity_signup);
        btnRegister = findViewById(R.id.btnRegister);

        edtUserName = findViewById(R.id.edtusename);
        edtPassword = findViewById(R.id.edtpassword);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUserName.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if(TextUtils.isEmpty(username)){
                    edtUserName.setError("Please enter username");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    edtPassword.setError("Please enter password");
                    return;
                }
                //save data
                FileOutputStream fileOutput = null;
                try {
                    username = username +"|";
                    fileOutput = openFileOutput("user.txt",MODE_APPEND);
                    fileOutput.write(username.getBytes(StandardCharsets.UTF_8));
                    fileOutput.write(password.getBytes(StandardCharsets.UTF_8));
                    fileOutput.write('\n');
                    fileOutput.close();//dong file
                    edtUserName.setText("");
                    edtPassword.setText("");
                    Toast.makeText(SignUpActivity.this,"Register successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this,Login_activity.class);
                    startActivity(intent);

                } catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
