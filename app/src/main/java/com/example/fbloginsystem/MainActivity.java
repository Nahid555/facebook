package com.example.fbloginsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginId,createId;
    EditText nameId,passId;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        nameId=findViewById(R.id.nameId);
        passId=findViewById(R.id.passwordId);
        loginId=findViewById(R.id.loginId);
        createId=findViewById(R.id.creatId);

        loginId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shared shared=new Shared(getApplicationContext());
               shared.loadData();
                String name=nameId.getText().toString();
                String pass=passId.getText().toString();
            if (nameId.getText().toString().equals(name) && passId.getText().toString().equals(pass)){
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
                finish();
                 shared=new Shared(getApplicationContext());
                shared.secondTime();
            }
            else {
                Toast.makeText(getApplicationContext(),"Invalid user name or password",Toast.LENGTH_SHORT).show();
            }
            }
        });
        createId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Shared shared=new Shared(getApplicationContext());
                shared.saveData();
                Toast.makeText(getApplicationContext(),"user name and password seved",Toast.LENGTH_SHORT).show();
                nameId.setText("");
                passId.setText("");
            }
        });

    }




}
