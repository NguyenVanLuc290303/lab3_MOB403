package com.example.lab3_mob403.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3_mob403.R;
import com.example.lab3_mob403.modal.androidVersion;

import java.util.ArrayList;

public class androidAdapter extends RecyclerView.Adapter<androidAdapter.ViewHolder> {
    Context context;
    ArrayList<androidVersion> arrayList;

    public androidAdapter(Context context, ArrayList<androidVersion> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_bai3,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        androidVersion adVersion = arrayList.get(position);
        holder.tv_name.setText(adVersion.getName());
        holder.tv_version.setText(adVersion.getVer());
        holder.tv_levelAPI.setText(adVersion.getApi());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name,tv_version,tv_levelAPI;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_version = itemView.findViewById(R.id.tv_version);
            tv_levelAPI = itemView.findViewById(R.id.tv_levelAPI);

        }
    }
}
