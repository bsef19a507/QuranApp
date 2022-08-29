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

public class SurahNameAdapter extends ArrayAdapter<tsurah>  {

        public SurahNameAdapter(@NonNull Context context, ArrayList<tsurah> surah) {
            super(context, 0, surah);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            tsurah myclass = getItem(position);
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.surahname, parent, false);
            TextView no = convertView.findViewById(R.id.SurahNo);
             no.setText(String.valueOf( myclass.getSurahID()));

            TextView surahNameE = convertView.findViewById(R.id.SurahNameE);
            surahNameE.setText( myclass.getSurahNameE());

            TextView surahNameU = convertView.findViewById(R.id.surahNameU);
            surahNameU.setText( myclass.getSurahNameU());
            TextView nazool = convertView.findViewById(R.id.Nazool);
            nazool.setText( myclass.getNazool());

            return convertView;
        }

    }
