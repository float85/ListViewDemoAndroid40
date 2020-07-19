package com.float85.demolistv3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailListview extends AppCompatActivity {
    EditText etNameList;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lisview);

        etNameList = findViewById(R.id.etNameList);
        btnSave = findViewById(R.id.btnSave);

        final Intent intent = getIntent();
        String intentName = intent.getStringExtra("keyName");

        etNameList.setText(intentName);

        if (intentName.length() > 0) {
            btnSave.setText("Update");
        }else {
            btnSave.setText("Add");
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent();
                intent1.putExtra("newName", etNameList.getText().toString());

                setResult(RESULT_OK, intent1);
                finish();
            }
        });


    }
}