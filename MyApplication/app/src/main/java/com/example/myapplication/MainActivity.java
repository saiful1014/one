package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText e1,e2;
    private Button b;

    DatabaseReference my=  FirebaseDatabase.getInstance().getReference("message");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=findViewById(R.id.et1);
        e2=findViewById(R.id.et2);
        b=findViewById(R.id.b1);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String name=e1.getText().toString().trim();
        String age=e2.getText().toString().trim();
        String key= my.push().getKey();
        store s=new store(name,age);
        my.child(key).setValue(s);
        Toast.makeText(this, "your data stored", Toast.LENGTH_SHORT).show();






    }
}