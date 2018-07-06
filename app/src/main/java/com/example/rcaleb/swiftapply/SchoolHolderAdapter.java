package com.example.rcaleb.swiftapply;

import android.content.Context;
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

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class SchoolHolderAdapter extends RecyclerView.Adapter<SchoolHolderAdapter.SchoolViewHolder> {

    Context context;
    LayoutInflater inflater;
    ArrayList<SchoolHolder> dataList;

    public SchoolHolderAdapter(Context context, ArrayList<SchoolHolder> dataList){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.dataList=dataList;


    }
    public SchoolViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_school_item,parent,false);
        SchoolViewHolder holder = new SchoolViewHolder(view);
        return holder;
    }


    public void onBindViewHolder(@NonNull SchoolViewHolder holder, int position) {
        Toast.makeText(context.getApplicationContext(),""+position,Toast.LENGTH_SHORT).show();

        holder.name.setText(dataList.get(position).getSchool());
        Glide.with(context)
                .load(dataList.get(position).getBadge())
                .into(holder.badge);
        Toast.makeText(context.getApplicationContext(),""+position,Toast.LENGTH_SHORT).show();

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
