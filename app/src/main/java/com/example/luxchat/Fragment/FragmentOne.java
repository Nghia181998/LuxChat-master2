package com.example.luxchat.Fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.luxchat.Adapter.Adapter_chatone;
import com.example.luxchat.R;

public class FragmentOne extends Fragment {
    public View mview;
    public RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;

    private RecyclerView.LayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.fagment_one,container,false);
        recyclerView = mview.findViewById(R.id.recy);


        // sử dụng câu lệnh này nếu kích thước các hàng luôn
        // bằng nhau. việc này giúp list mượt hơn
        recyclerView.setHasFixedSize(true);

        // sử dụng LayoutManager để quy định kiểu hiển thị cho list là hàng dọc
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // Khai báo Adapter (mn xem tiếp ví dụ dưới nhé)
        mAdapter = new Adapter_chatone();
        recyclerView.setAdapter(mAdapter);
        return mview;
    }
}
