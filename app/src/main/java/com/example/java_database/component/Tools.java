package com.example.java_database.component;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Tools extends AppCompatActivity {
    Context c;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
         c = this;
        super.onCreate(savedInstanceState);

    }

    public void msg(String msg) {
        Toast.makeText(c, msg, Toast.LENGTH_SHORT).show();
    }
}
