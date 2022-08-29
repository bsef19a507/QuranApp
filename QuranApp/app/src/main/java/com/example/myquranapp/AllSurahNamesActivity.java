package com.example.myquranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AllSurahNamesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_surah_names);

        ListView AllSurahList = findViewById(R.id.AllSurahList);
        DBhelper dbHelper  = new DBhelper(AllSurahNamesActivity.this);

        ArrayList<tsurah> list =dbHelper.getAllSurah();
        Log.d("nameOFSurah", String.valueOf(list.get(1)));
        SurahNameAdapter arrayAdapter = new SurahNameAdapter (this,list);


        AllSurahList.setAdapter(arrayAdapter);

        AllSurahList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DBhelper dbHelper = new DBhelper(AllSurahNamesActivity.this);
                tsurah s= (tsurah) adapterView.getItemAtPosition(i);
                Intent intent = new Intent(AllSurahNamesActivity.this, SurahActivity.class);
                intent.putExtra("index", l + "");
                intent.putExtra("surahName", s.getSurahNameU());
                startActivity(intent);


            }
        });
    }
}