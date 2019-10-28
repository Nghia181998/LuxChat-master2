package com.example.luxchat.UI;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luxchat.MainActivity;
import com.example.luxchat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    Button btnsignin;
    EditText edtuser,edtpass;
    ActionBar actionBar;
    TextView tvforgot;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnsignin = findViewById(R.id.btnsign);
        edtuser = findViewById(R.id.account);
        edtpass = findViewById(R.id.passwordlogin);
        actionBar = getSupportActionBar();
        mFirebaseAuth = FirebaseAuth.getInstance();
        tvforgot = findViewById(R.id.tvfg);
        tvforgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,ResetPassActivity.class);
                startActivity(intent);
            }
        });
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#becff1")));
        btnsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtuser.getText().toString();
                String pwd = edtpass.getText().toString();
                if(email.isEmpty()){
                    edtuser.setError("Please enter email id");
                    edtuser.requestFocus();
                }
                else  if(pwd.isEmpty()){
                    edtpass.setError("Please enter your password");
                    edtpass.requestFocus();
                }
                else  if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
                }
                else  if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(LoginActivity.this,"Login Error, Please Login Again",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Intent intToHome = new Intent(LoginActivity.this,HomeActivity.class);
                                startActivity(intToHome);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(LoginActivity.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    public void SigUp(View view) {
        Intent intent
                = new Intent(LoginActivity.this,SigUpActivity.class);
        startActivity(intent);
    }
}
