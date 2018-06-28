package com.example.rcaleb.swiftapply;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.StatusView> {

    Context context;
    LayoutInflater inflater;
    List<StatusDataHolder> data;

    public StatusAdapter(Context context, List<StatusDataHolder> data) {
        this.context = context;
        inflater=LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public StatusView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_status,parent,false);
        StatusView holder = new StatusView(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StatusView holder, int position) {



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class StatusView extends RecyclerView.ViewHolder{
        ImageView status,image;
        TextView name;
        RelativeLayout has;
        public StatusView(View itemView) {
            super(itemView);

            status=(ImageView)itemView.findViewById(R.id.status);
            image=(ImageView)itemView.findViewById(R.id.img);
            has = (RelativeLayout) itemView.findViewById(R.id.touched);
            name= (TextView) itemView.findViewById(R.id.name);


        }
    }

}
