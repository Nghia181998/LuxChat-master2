package com.example.luxchat.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.luxchat.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SigUpActivity extends AppCompatActivity {
    Button btnsignup;
    EditText edtusername,edtpassword,edtrepass,edtemail;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sig_up);
        edtusername = findViewById(R.id.edtNguoidung);
        edtpassword = findViewById(R.id.edtmatkhau);
        edtrepass = findViewById(R.id.edtnhaplaiMk);
        edtemail = findViewById(R.id.edtTenDN);
        btnsignup = findViewById(R.id.button2);
        mFirebaseAuth = FirebaseAuth.getInstance();
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtemail.getText().toString();
                String pwd = edtpassword.getText().toString();
                String rep = edtrepass.getText().toString();
                String name = edtusername.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(email.isEmpty()){
                    edtemail.setError("Please enter email id");
                    edtemail.requestFocus();
                }
                else  if(!email.matches(emailPattern)){
                    edtemail.setError("It is not pattern Email");
                    edtemail.requestFocus();
                }
                else  if(pwd.isEmpty()){
                    edtpassword.setError("Please enter your password");
                    edtpassword.requestFocus();
                }
                else  if(!rep.matches(pwd)){
                    edtrepass.setError("Please enter your password right");
                    edtrepass.requestFocus();
                }
                else  if(rep.isEmpty()){
                    edtrepass.setError("Please enter your password");
                    edtrepass.requestFocus();
                }
                else  if(name.isEmpty()){
                    edtusername.setError("Please enter your name");
                    edtusername.requestFocus();
                }
                else  if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(SigUpActivity.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
                }
                else  if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(SigUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(SigUpActivity.this,"SignUp Unsuccessful, Please Try Again",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(SigUpActivity.this,HomeActivity.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(SigUpActivity.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
