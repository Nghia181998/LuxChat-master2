package com.example.luxchat.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.luxchat.R;

public class Adapter_chatone extends RecyclerView.Adapter<Adapter_chatone.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view_chat_one, parent, false);

      ViewHolder vh = new ViewHolder(v);
        return vh ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvuserchat,tvlastcontent;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            tvuserchat = itemView.findViewById(R.id.tvuserchat);
            tvlastcontent = itemView.findViewById(R.id.tvcontentlast);
        }
    }
}
