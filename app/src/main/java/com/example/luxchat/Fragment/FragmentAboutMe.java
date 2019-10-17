package com.example.luxchat.Fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.luxchat.R;
import com.example.luxchat.UI.HomeActivity;
import com.example.luxchat.UI.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class FragmentAboutMe extends Fragment {
    public View mview;
    public TextView tvlogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mview = inflater.inflate(R.layout.fragment_about_me,container,false);
        tvlogout = mview.findViewById(R.id.logout);
        tvlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(getActivity(), LoginActivity.class);
                startActivity(intToMain);
            }
        });
        return mview;

    }
}
