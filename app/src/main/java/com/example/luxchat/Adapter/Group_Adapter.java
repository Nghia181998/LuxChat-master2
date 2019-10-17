package com.example.luxchat.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.luxchat.R;

public class Group_Adapter extends  RecyclerView.Adapter<Group_Adapter.ViewHolder2> {

@NonNull
@Override
public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item_view_chatgroup, parent, false);

        ViewHolder2 vh = new ViewHolder2(v);
        return vh ;
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder2 holder, int position) {

        }

@Override
public int getItemCount() {
        return 10;
        }

public class ViewHolder2 extends RecyclerView.ViewHolder {
    TextView tvuserchat,tvlastcontent;
    public ViewHolder2(@NonNull View itemView) {

        super(itemView);
        tvuserchat = itemView.findViewById(R.id.tvusergroup);
        tvlastcontent = itemView.findViewById(R.id.tvcontentlast2);
    }
}
}
