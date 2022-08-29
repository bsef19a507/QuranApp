package com.example.myquranapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBhelper extends SQLiteOpenHelper {


    public DBhelper(@Nullable Context context)
    {
        super(context, "QuranDb.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public ArrayList<tsurah> getAllSurah(){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM " + "tsurah", null);

        ArrayList<tsurah> ArrayList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {

             ArrayList.add(new tsurah(cursor.getInt(0),cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));
            } while (cursor.moveToNext());

        }

        cursor.close();
        return ArrayList;
    }

    public ArrayList<tayah> Surah(int index){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT *" + " FROM " + "tayah" + " WHERE " + "SuraID" + " = '" + index + "'";
        Cursor data = db.rawQuery(query, null);

        ArrayList<tayah> surah = new ArrayList<>();

        if (data.moveToFirst()) {
            do {
                surah.add(new tayah(data.getInt(0), data.getInt(1), data.getInt(2),data.getString(3),data.getString(4),data.getString(5),data.getString(6),data.getString(7),data.getInt(8),data.getInt(9),data.getInt(10)));
            } while (data.moveToNext());

        }
        data.close();
        return  surah;
    }
}
