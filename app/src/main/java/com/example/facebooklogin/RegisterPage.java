package com.example.facebooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity {
Database my_db;
EditText u_name,Email,Pass;
Button sign_up_btn,GoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register_page);
        my_db=new Database(getBaseContext());
        u_name=findViewById(R.id.RegUseranme);
        Email=findViewById(R.id.Regemail);
        Pass=findViewById(R.id.Regpass);
        sign_up_btn=findViewById(R.id.Signup_btn);
        GoButton=findViewById(R.id.Go_login);
        sign_up_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my_db.insertData(new User(Email.getText().toString().toLowerCase(),Pass.getText().toString(),u_name.getText().toString()));
                Toast.makeText(RegisterPage.this, "ADD successfully And go to login", Toast.LENGTH_SHORT).show();
                Intent i=new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
            }
        });

GoButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(getBaseContext(), MainActivity.class);
        startActivity(i);
    }
});

    }
}