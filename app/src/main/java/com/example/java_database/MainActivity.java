package com.example.java_database;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.java_database.component.Tools;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends Tools {
    FloatingActionButton saveBtn;
    EditText mName, nContact, mDob;
    String sName, sContact, sDob;
    DbHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB=new DbHelper(this);

        mName = findViewById(R.id.name);
        nContact = findViewById(R.id.contact);
        mDob = findViewById(R.id.dob);

        saveBtn = findViewById(R.id.Save);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sName =mName.getText().toString().trim();
                sContact =nContact.getText().toString().trim();
                sDob =mDob.getText().toString().trim();
                Log.d("Atique", "onClick: "+sName +sContact +sDob);
              Boolean  dataInsertCheck = DB.insertData(sName,sContact,sDob);

                if(dataInsertCheck == true){
                    msg("Data Save");
                    mName.getText().clear();
                    nContact.getText().clear();
                    mDob.getText().clear();
                } msg("Failed ");
            }
        });

    }
}