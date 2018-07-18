package com.example.rcaleb.swiftapply;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class SelectPreferedSchool extends AppCompatActivity {

    RecyclerView schoolItem;
    ImageView back;
    ArrayList<SchoolHolder> SchoolList = new ArrayList<>();
    String Url ="http://192.168.43.253/data/swiftApply/pickschools.php";



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_prefered_school);
        schoolItem = (RecyclerView) findViewById(R.id.school_recy);


     SchoolRequesting();


        back = (ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SelectPreferedSchool.this,application_status.class));

            }
        });



    }

    private void SchoolRequesting() {
        JsonArrayRequest schoolListRequest = new JsonArrayRequest(Request.Method.GET, Url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int counter = 0;

                while(counter < response.length()) {

                    try {

                        JSONObject school = response.getJSONObject(counter);

                        SchoolHolder somero = new SchoolHolder(school.getString("badge"), school.getString("school"),
                                school.getString("location"),school.getString("banner"),
                                school.getString("phone_number"), school.getString("website"),
                                school.getString("server_url"),school.getString("description"));

                        SchoolList.add(somero);
                                   counter++;

                    }catch (JSONException e){

                        Toast.makeText(SelectPreferedSchool.this,"Error Occured in Object",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                }
                        adapterSetup();
            }
        }, new Response.ErrorListener() {
            @Override

            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SelectPreferedSchool.this,"Unable to fetch data: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                error.printStackTrace();
            }
        });

        MySingletonPartern.getInstance(this).addToRequestQueue(schoolListRequest);


    }

    public void adapterSetup(){

        SchoolHolderAdapter schoolHolderAdapter = new SchoolHolderAdapter(this,SchoolList);
        schoolItem.setLayoutManager(new LinearLayoutManager(this));

        schoolItem.setAdapter(schoolHolderAdapter);




    }
}
