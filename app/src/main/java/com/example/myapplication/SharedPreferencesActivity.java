package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SharedPreferencesActivity extends AppCompatActivity {
    EditText edtNumber1,edtNumber2,edtResult;
    Button btnSumData,btnClearData;
    String history ="";//luu tru cac ket qua vao share preference
    TextView tvHistory;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        edtResult = findViewById(R.id.edtResult);
        btnSumData = findViewById(R.id.btnSumData);
        btnClearData = findViewById(R.id.btnClearData);
        tvHistory = findViewById(R.id.dpHistory);
        edtResult.setEnabled(false);
        //get data from share Prefrences
        SharedPreferences myPrf = getSharedPreferences("Calculator Plus",MODE_PRIVATE);
        history = myPrf.getString("OPERATOR PUSH","");
        tvHistory.setText(history);
        btnSumData.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                long number1 = Integer.parseInt(edtNumber1.getText().toString().trim());
                long number2 = Integer.parseInt(edtNumber2.getText().toString().trim());
                long result = number1 + number2;
                edtResult.setText(String.valueOf(result));
                history += number1 + " + " + number2 + " = " + result;
                tvHistory.setText(history);
                history += "\n";




            }
        });
        btnClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history ="";
                tvHistory.setText("");
                edtNumber1.setText("");
                edtNumber2.setText("");
                edtResult.setText("");
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        //luu du lieu vao share preferences
        SharedPreferences myPrf = getSharedPreferences("Calculator Plus",MODE_PRIVATE);
        SharedPreferences.Editor editor = myPrf.edit();
        editor.putString("OPERATOR PUSH",history);
        editor.apply();

    }
}
