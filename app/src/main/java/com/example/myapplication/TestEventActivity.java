package com.example.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TestEventActivity extends AppCompatActivity {
    EditText edtData;
    private Button btnClickme;
    private Button btnClearData;
    private CheckBox cbBlock;
    private TextView tvTitle;
    private RadioGroup radAddress;
    private RadioButton rbHn,rbTh;

    @Override


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_event);
        //anh sa view
        edtData = findViewById(R.id.edtData);
        btnClickme = findViewById(R.id.btnClickme);
        btnClearData = findViewById(R.id.btnClearData);
        cbBlock = findViewById(R.id.cbBlock);
        tvTitle = findViewById(R.id.tvTitle);
        radAddress = findViewById(R.id.radAddress);
        rbHn = findViewById(R.id.rbHn);
        rbTh = findViewById(R.id.rbTh);

        //block
        //bat su kien click
        edtData.setEnabled(false);
        btnClickme.setEnabled(false);
        btnClearData.setEnabled(false);

        btnClickme.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String data = edtData.getText().toString().trim();
                if (TextUtils.isEmpty(data)) {
                    edtData.setError("Can not empty,please enter data");
                    return;
                }
                Toast.makeText(TestEventActivity.this, data, Toast.LENGTH_SHORT).show();
                int selectedId = radAddress.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectedId);
                String address = radioButton.getText().toString().trim();
                Toast.makeText(TestEventActivity.this, address, Toast.LENGTH_SHORT).show();
            }


        });
        cbBlock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    edtData.setEnabled(true);
                    btnClickme.setEnabled(true);
                    btnClearData.setEnabled(true);
                } else {
                    edtData.setEnabled(false);
                    btnClickme.setEnabled(false);
                    btnClearData.setEnabled(false);
                }
            }

        });
        btnClearData.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                edtData.setText(" ");

            }
        });
        edtData.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String conten = s.toString().trim();//lay noi dung nhap vao edit text
                tvTitle.setText(conten);
            }
        });

    }

}
