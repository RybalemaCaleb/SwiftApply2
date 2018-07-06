package com.example.rcaleb.swiftapply;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingletonPartern  {
    private  Context mCxt;
    private static MySingletonPartern mInstance;
    private RequestQueue requestQueue;

    private MySingletonPartern(Context context){
        this.mCxt=context;
        requestQueue=getRequestQueue();

    }

    public static synchronized MySingletonPartern getInstance(Context context) {
        if(mInstance==null)
            mInstance=new MySingletonPartern(context);
        return mInstance;
    }


    public RequestQueue getRequestQueue() {
        if(requestQueue==null)
            requestQueue = Volley.newRequestQueue(mCxt.getApplicationContext());
        return requestQueue;
    }

    public<T> void addRequestQueue(Request<T> request){
        requestQueue.add(request);
    }
}
