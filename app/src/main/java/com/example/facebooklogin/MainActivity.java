package com.example.facebooklogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Database my_db;
EditText email,pass;
Button loginbtn,GO_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        my_db=new Database(getBaseContext());

GO_signup=findViewById(R.id.Go_signup);
        loginbtn=findViewById(R.id.Login_btn);
        email=findViewById(R.id.Login_email);
        pass = findViewById(R.id.Login_pass);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean Isfound=my_db.selectData(new User(email.getText().toString(),pass.getText().toString()));
                if(Isfound==true){
                    Toast.makeText(MainActivity.this, "loginSuccess", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "LoginFailed", Toast.LENGTH_SHORT).show();
                }
            }
        });

GO_signup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i =new Intent(getBaseContext(), RegisterPage.class);
        startActivity(i);
    }
});
    }
}