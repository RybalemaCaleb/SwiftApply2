package com.example.rcaleb.swiftapply;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {


    TextInputLayout email,password,password1,nin;
    String Email,Password,Password1,Nin;
    String registerUrl="http://192.168.43.254/data/swiftApply/adduser.php";
    Button register,backtoSignin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email =findViewById(R.id.email);
        nin = findViewById(R.id.NIN);
        password =findViewById(R.id.password);
        password1 =findViewById(R.id.password1);
        register = (Button)findViewById(R.id.sign_up);
        backtoSignin = (Button) findViewById(R.id.sign_in);

        backtoSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateEmail() | !validateNin() | !validatePassword() | !validatePassword1() | validatePasswords()) {
                        return;
                    }

                registerUser();
            }
        });



    }

    private boolean validatePassword() {
        Password = password.getEditText().getText().toString().trim();

        if (Password.isEmpty()) {
            password.setError("Field can't be empty");
            return false;
        }
        else if (Password.length() < 8) {
            password.setError("Password Should be at least 8 Characters");
            return false;

        } else {
            password.setError(null);
            return true;
        }
    }

        private boolean validatePassword1() {
            Password1 = password1.getEditText().getText().toString().trim();

            if (Password1.isEmpty()) {
                password1.setError("Field can't be empty");
                return false;
            }else if (Password1.length() < 8) {
            password1.setError("Password Should be at least 8 Characters");
            return false;
            }
            else {
                password1.setError(null);
                return true;
            }
    }
    private boolean validateNin() {
        Nin = nin.getEditText().getText().toString().trim();

        if (Nin.isEmpty()) {
            nin.setError("Field can't be empty");
            return false;
        }else if (Nin.length() != 14) {
            nin.setError("NIN should be 14 Characters");
            return false;
        }
        else
            {
            nin.setError(null);
            return true;
        }

    }
        private  boolean validatePasswords(){

        if(Password.equals(Password1))
            return  true;
            else{
                password1.setError("Password does not match");

                return false;
}



    }



    private boolean validateEmail() {
        Email = email.getEditText().getText().toString().trim();

        if (Email.isEmpty()) {
            email.setError("Field can't be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){

            email.setError("Invalid Email Address");
            return  false;

        }
            else {
            email.setError(null);
            return true;
        }

    }
    public void registerUser(){

        StringRequest request = new StringRequest(Request.Method.POST, registerUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(),""+response,Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Something Went Wrong",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<>();

                map.put("email",Email);
                map.put("nin",Nin);
                map.put("password",Password);
                return map;
            }
        };

        MySingletonPartern.getInstance(this).addToRequestQueue(request);
    }
}
