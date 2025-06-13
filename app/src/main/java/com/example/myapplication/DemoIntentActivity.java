package com.example.myapplication;

import static android.Manifest.permission.CALL_PHONE;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class DemoIntentActivity extends AppCompatActivity {
    EditText  editUrl;
    Button btnUrl;
    Button btnCall;
    EditText edtPhone;
    Button btnGotoActivity;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_intent);
        editUrl = findViewById(R.id.edtURL);
        btnUrl = findViewById(R.id.btnLoadURL);
        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lay dia chi url nhap vao
                String url = editUrl.getText().toString();
                if(TextUtils.isEmpty(url)){
                    editUrl.setError("enter url");
                    return;
                }
                //load noi dung website tu url cua trang web dos
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
        btnCall = findViewById(R.id.btnCallPhone);
        edtPhone = findViewById(R.id.edtPhoneNumber);
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phone = edtPhone.getText().toString();
                if(TextUtils.isEmpty(phone)){
                    edtPhone.setError("enter phone number");
                    return;
                }
                //call phone number
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+phone));
                //check thiet bi di dong co dcc call phone hay ko
                if(ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE)== PackageManager.PERMISSION_GRANTED)
                {
                    startActivity(intent);
                }
                else {
                    //xin quyen call phone
                    requestPermissions(new String[]{CALL_PHONE},1);

                }
            }
        });
        btnGotoActivity =findViewById(R.id.btnGotoAcitivity);
        btnGotoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DemoIntentActivity.this,TestSecondActivity.class);
                startActivity(intent);
                String url = editUrl.getText().toString();
                String phone = edtPhone.getText().toString();
                //chuyen sang man hinh activity khac va chuyen du lieu
                Intent intent1 = new Intent(DemoIntentActivity.this,DemoComponentActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Myurl",url);
                bundle.putString("myphone",phone);
                bundle.putInt("userid",123456789) ;
                intent1.putExtras(bundle);
                startActivity(intent1);

            }
        });
    }
}
