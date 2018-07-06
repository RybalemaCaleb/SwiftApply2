package com.example.rcaleb.swiftapply;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.bumptech.glide.util.LogTime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class SchoolHolder {
    private Context context;
    private String school;
    private String description;
    private String sever_url;
    private String banner_url;
    private String location;
    private String badge;
    private String website;
    private String phone_number;
    String severUrl="http://10.103.5.126/data/swiftApply/pickschools.php";

    public SchoolHolder(Context context) {
        this.context = context;
    }


    ArrayList<SchoolHolder> dataList;

    {
        dataList = new ArrayList<>();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSever_url() {
        return sever_url;
    }

    public void setSever_url(String sever_url) {
        this.sever_url = sever_url;
    }

    public String getBanner_url() {
        return banner_url;
    }

    public void setBanner_url(String banner_url) {
        this.banner_url = banner_url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public ArrayList<SchoolHolder> getSchoolinfoList(){

        JsonArrayRequest schools = new JsonArrayRequest(severUrl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                int i=0;

                while(i<response.length()) {

                    try {
                        JSONObject JsonSchool = response.getJSONObject(i);
                        SchoolHolder schoolHolder = new SchoolHolder(context);

                        schoolHolder.setSchool(JsonSchool.getString("school"));

                        schoolHolder.setBadge(JsonSchool.getString("badge"));

                        schoolHolder.setBanner_url(JsonSchool.getString("banner"));

                        schoolHolder.setDescription(JsonSchool.getString("description"));

                        schoolHolder.setLocation(JsonSchool.getString("location"));

                        schoolHolder.setPhone_number(JsonSchool.getString("phone_number"));

                        schoolHolder.setWebsite(JsonSchool.getString("website"));

                        schoolHolder.setSever_url(JsonSchool.getString("badge"));
                            dataList.add(schoolHolder);

                        i++;
                        Toast.makeText(context.getApplicationContext(),""+dataList.size(),Toast.LENGTH_SHORT).show();
                    }catch (JSONException e){
                        Toast.makeText(context.getApplicationContext(),"Error Occurred in Object!!!",Toast.LENGTH_SHORT).show();
                        e.printStackTrace();

                    }


                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context.getApplicationContext(),"Error Occurred!!!",Toast.LENGTH_SHORT).show();
                error.printStackTrace();

            }
        });

        MySingletonPartern.getInstance(context).addRequestQueue(schools);


        return dataList;
    }




}
