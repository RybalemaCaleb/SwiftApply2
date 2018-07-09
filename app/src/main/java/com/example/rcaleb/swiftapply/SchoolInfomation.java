package com.example.rcaleb.swiftapply;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class SchoolInfomation extends AppCompatActivity {
    final static int REQUEST_CALL=1;
    ImageView call,vist_site,Continue,banner,badge;
    TextView Location,School_name,description;
    String bannerUrl,badgeUrl,WebsiteUrl,PhoneNumber,Locationdata,descriptiondata,namedata,phonedata;

    RecyclerView recyclerView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_infomation);

        call= (ImageView)findViewById(R.id.call_now);
        vist_site= (ImageView)findViewById(R.id.visit_site);
        Continue = (ImageView)findViewById(R.id.apply_now);
        banner =(ImageView) findViewById(R.id.banner);
        badge = (ImageView) findViewById(R.id.school_badge);


        Location = (TextView) findViewById(R.id.school_Location);
        School_name =(TextView) findViewById(R.id.school_NAME);
        description = (TextView)findViewById(R.id.description);


        //Get Information from previous Activity

        bannerUrl= getIntent().getExtras().getString("banner");
        WebsiteUrl= getIntent().getExtras().getString("WebsiteUrl");
        badgeUrl= getIntent().getExtras().getString("badge");
        Locationdata = getIntent().getExtras().getString("Location");
        descriptiondata= getIntent().getExtras().getString("Description");
        namedata= getIntent().getExtras().getString("School_name");
        phonedata= getIntent().getExtras().getString("Phone_number");

        //Set data to View
        School_name.setText(namedata);
        Location.setText(Locationdata);
        description.setText(descriptiondata);

        // Load Images
        Glide.with(this)
                .asBitmap()
                .load(badgeUrl)
                .apply(new RequestOptions().override(300,200).fitCenter())
                .into(badge);

        Glide.with(this)
                .asBitmap()
                .load(bannerUrl)
                .apply(new RequestOptions().fitCenter())
                .into(banner);


        //Setting up the calling Intent

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhonecall();

                    }

            }
        );
       //Website Viewing

        vist_site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(WebsiteUrl));

                if(intent.resolveActivity(getPackageManager()) != null)  //if apps which can handle the activity not absent
                startActivity(intent);

                else
                    Toast.makeText(SchoolInfomation.this,"Sorry You Phone doesnot Support this Service, But you can continue with your Application process",Toast.LENGTH_LONG).show();
            }
        });
    }


    public void makePhonecall(){



        if (ActivityCompat.checkSelfPermission(SchoolInfomation.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(SchoolInfomation.this, new String[]{
                    Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }
        else {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse( "tel:"+phonedata));
            startActivity(callIntent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){

                makePhonecall();

            }else
            {
                Toast.makeText(this,"Your Permission is required",Toast.LENGTH_SHORT).show();
            }
        }
    }


}
