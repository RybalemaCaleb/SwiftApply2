package com.example.rcaleb.swiftapply;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class SelectPreferedSchool extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<SchoolHolder> theList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select_prefered_school);

        recyclerView = (RecyclerView) findViewById(R.id.recy_School);

        SchoolHolder schoolHolder = new SchoolHolder(this);

        theList=schoolHolder.getSchoolinfoList();


        Toast.makeText(this,""+theList.size(),Toast.LENGTH_SHORT).show();

        SchoolHolderAdapter schoolHolderAdapter = new SchoolHolderAdapter(this,theList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(schoolHolderAdapter);


    }
}
