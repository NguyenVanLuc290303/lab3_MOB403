package com.example.lab3_mob403.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3_mob403.R;
import com.example.lab3_mob403.modal.contact;

import java.util.ArrayList;

public class contactAdapter extends RecyclerView.Adapter<contactAdapter.ViewHolder> {

    ArrayList<contact> contactArrayList;
    Context context;

    public contactAdapter(ArrayList<contact> contactArrayList, Context context) {
        this.contactArrayList = contactArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_contacts, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        contact ct = contactArrayList.get(position);
        holder.tv_name.setText(ct.getName());
        holder.tv_email.setText(ct.getEmail());
        holder.tv_address.setText(ct.getAddress());
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name ,tv_email, tv_address ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name =  itemView.findViewById(R.id.tv_name);
            tv_email =  itemView.findViewById(R.id.tv_email);
            tv_address =  itemView.findViewById(R.id.tv_address);

        }
    }
}
