package com.example.myapplication;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class DemoComponentActivity extends AppCompatActivity {
    Button btnExtapp;
    EditText edtDate;
    TextView tvid,tvurl,tvphone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_component);
        btnExtapp = findViewById(R.id.btnExitApp);
        btnExtapp.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(DemoComponentActivity.this);
                builder.setMessage("do you want exit app?");
                builder.setTitle("Alert !!!");
                builder.setCancelable(false);
                builder.setPositiveButton("yes",(DialogInterface.OnClickListener) (dialog,which)->{
                    //btn yes thoat app
                finish();
                });
                builder.setNegativeButton("no",(DialogInterface.OnClickListener) (dialog,which)->
                {
                    dialog.cancel();//ko lam gi ca
                    //btn no
                });
                AlertDialog alertDialog = builder.create();
              alertDialog.show();
            }


            //tao hop thoai thong bao(Alert Dialog)
        });
        edtDate = findViewById(R.id.edtTime);
        edtDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Calendar calendar= Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                //tao dat picker dialog
                DatePickerDialog datePicker = new DatePickerDialog(
                        DemoComponentActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date = dayOfMonth + "-"+ (month +1)+ "-" + year;
                        edtDate.setText(date);
                    }
                },year,month,day);
                datePicker.setCancelable(false);
                datePicker.show();
            }
        });
        tvid = findViewById(R.id.tbUserID);
        tvurl = findViewById(R.id.tvURL);
        tvphone = findViewById(R.id.tvPhone);
        //get data from DemoIntentActivity
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null){
            String url = bundle.getString("Myurl");
            String phone = bundle.getString("myphone");
            int userID = bundle.getInt("userid",238);
            tvid.setText("User ID :"+ String.valueOf(userID));
            tvurl.setText("URL : "+url);
            tvphone.setText("PHONE"+phone);

        }


    }
}
