package com.example.rcaleb.swiftapply;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class SchoolRequest {

    ArrayList<SchoolHolder> schoolList;
    Context context;
    String Url ="http://192.168.43.253/data/swiftApply/pickschools.php";
    private static final String TAG = "debug";


    public SchoolRequest(Context context){
        this.context=context;
        schoolList = new ArrayList<>();
    }

    public ArrayList<SchoolHolder> getSchoolList(){


        return schoolList;
    }



}


