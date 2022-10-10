package com.example.java_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper( Context context) {
        super(context, "Userdetails.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Userdetails (name Text primary key , contact TEXT , dob TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists Userdetails");

    }

    public Boolean insertData(String name, String contact,String dob){
        SQLiteDatabase DB =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("contact",contact);
        contentValues.put("dob",dob);
        long result = DB.insert("Userdetails",null,contentValues);

        if (result == 1){
            return false;
        }return true;
    }

    public Cursor getData(){
        SQLiteDatabase DB =this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM Userdetails",null);
        return cursor;
    }
}
