package com.example.myquranapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SurahAdapter  extends ArrayAdapter<tayah> {


    public SurahAdapter(@NonNull Context context, ArrayList<tayah> surah) {
        super(context, 0, surah);
    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        tayah myclass = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.surah_customized_view, parent, false);
        TextView ayat = convertView.findViewById(R.id.surahAyat);
         ayat.setText(String.valueOf( myclass.getArabicText()));
        TextView ayattrjama = convertView.findViewById(R.id.ayattrjama);
        ayattrjama.setText(String.valueOf( myclass.getFatehMuhammadJaland()));

        return convertView;
    }

}
