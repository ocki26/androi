package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class TestActivity extends AppCompatActivity {
    Button btnFistActivity;
    private static  final String LOG_ACTIVITY = "TestActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //khai bao cac bien load layout giao dien
        //chay ngay khi co 1 acitity kich hoat
        setContentView(R.layout.activity_test);
        Log.i(LOG_ACTIVITY,"******* onCreate *******");
        // anh sa view thong qua id
        btnFistActivity = findViewById(R.id.btnFistActivity);
        //bat su kien click
        btnFistActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(TestActivity.this, "go to an other activity", Toast.LENGTH_SHORT).show();
                //di sang activity khac
                Intent intent = new Intent(TestActivity.this,TestSecondActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_ACTIVITY,"******* ONSTART *******");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_ACTIVITY,"******* on resume *******");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //ham nay se dc goi khi co 1 acitit moi dc kich hoat
        Log.i(LOG_ACTIVITY,"******* on pause *******");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //khi 1 activity bi an di nhung cho acivity khac hienj moi
        Log.i(LOG_ACTIVITY,"******* on stop *******");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        //ham nay se chay khi 1 activity bi an di
        //keo theo ca ham onstart on resume chay lai
        Log.i(LOG_ACTIVITY,"******* on restart *******");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //ham nay se dc goi khi 1 activity bi huy ,giai phong khoi dung luong thiet bi
        Log.i(LOG_ACTIVITY,"******* on destroy *******");
    }
}
