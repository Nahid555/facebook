package com.example.fbloginsystem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class Shared {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    LayoutInflater inflater;
    Context context;
    int m=0;
    String data="b";

    Shared(Context context){
        this.context=context;
        sharedPreferences=context.getSharedPreferences("FileName",0);
        editor=sharedPreferences.edit();
    }

    public void secondTime(){
        editor.putBoolean(data,true);
        editor.commit();
    }

    public void firstTime(){
        if (!this.login()){
            Intent intent=new Intent(context.getApplicationContext(),MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }
    }
    public boolean login(){
        return sharedPreferences.getBoolean(data,false);
    }

    public void saveData(){
         inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       View view= inflater.inflate(R.layout.activity_main,null,false);
      EditText name= view.findViewById(R.id.nameId);
      EditText pass= view.findViewById(R.id.passwordId);

        sharedPreferences=context.getSharedPreferences("FileName",0);
        editor=sharedPreferences.edit();
        editor.putString("name", String.valueOf(name));
        editor.putString("pass", String.valueOf(pass));
        editor.commit();
    }
    public void loadData(){
        sharedPreferences=context.getSharedPreferences("FileName",0);
        String username=sharedPreferences.getString("name","data not found");
        String userPass=sharedPreferences.getString("pass","data not found");

        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.activity_main,null,false);
        EditText name= view.findViewById(R.id.nameId);
        EditText pass= view.findViewById(R.id.passwordId);
        name.setText(username);
        pass.setText(userPass);


    }
}
