package com.example.rcaleb.swiftapply;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class application_status extends AppCompatActivity {

    Button addApplication;
    TextView statusinfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_status);
        addApplication = (Button)findViewById(R.id.add_application);
        statusinfo = (TextView) findViewById(R.id.msg);


        addApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(application_status.this,SelectPreferedSchool.class));
            }
        });




    }
}
