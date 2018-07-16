package com.example.rcaleb.swiftapply;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class SchoolHolderAdapter extends RecyclerView.Adapter<SchoolHolderAdapter.SchoolViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<SchoolHolder> dataList;
    RequestOptions options;

    public SchoolHolderAdapter(Context context, ArrayList<SchoolHolder> ReceivedList){
        this.context = context;
        inflater = LayoutInflater.from(context);
        dataList=ReceivedList;
        options = new RequestOptions().override(300,200).fitCenter();




    }
    public SchoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_school_item,parent,false);
        SchoolViewHolder holder = new SchoolViewHolder(view);
        return holder;
    }


    public void onBindViewHolder(@NonNull final SchoolViewHolder holder, final int position) {


        holder.name.setText(dataList.get(position).getSchool());


        Glide.with(context)
                .asBitmap()
                .load(dataList.get(position).getBadge())
                .apply(options)
                .into(holder.badge);


        holder.school.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SchoolInfomation.class);

                intent.putExtra("School_name",dataList.get(position).getSchool());
                intent.putExtra("Location",dataList.get(position).getLocation());
                intent.putExtra("banner",dataList.get(position).getBanner());
                intent.putExtra("badge",dataList.get(position).getBadge());
                intent.putExtra("Phone_number",dataList.get(position).getPhone_number());
                intent.putExtra("WebsiteUrl",dataList.get(position).getWebsite());
                intent.putExtra("Description",dataList.get(position).getDescription());

                context.startActivity(intent);

            }
        });
    }


    public int getItemCount() {


        return dataList.size();
    }

    public class SchoolViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView badge;
        RelativeLayout school;


        public SchoolViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.school_name);
            badge = (ImageView) itemView.findViewById(R.id.school_badge);
            school = (RelativeLayout) itemView.findViewById(R.id.schoolid);
        }


    }
}
