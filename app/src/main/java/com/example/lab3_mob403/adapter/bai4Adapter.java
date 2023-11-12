package com.example.lab3_mob403.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3_mob403.R;
import com.example.lab3_mob403.modal.contact;
import com.example.lab3_mob403.modal.contacts;
import com.example.lab3_mob403.modal.photos;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class bai4Adapter extends RecyclerView.Adapter<bai4Adapter.ViewHolder> {
    Context context;
    List<photos> arrayList;

    public bai4Adapter(Context context, List<photos> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_bai4,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        photos cts = arrayList.get(position);
        holder.tv_name.setText(cts.getTitle());
//        holder.tv_email.setText(cts.getAlbumId());
        Picasso.get().load(cts.getUrl()).into(holder.img_contacts);
    }

    @Override
    public int getItemCount() {

        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_contacts;
        TextView tv_name,tv_email;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_contacts = itemView.findViewById(R.id.img_contact);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_email = itemView.findViewById(R.id.tv_email);
        }
    }
}
