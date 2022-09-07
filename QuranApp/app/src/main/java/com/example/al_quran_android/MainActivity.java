package com.example.al_quran_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;  //Recyclerview imported here...


import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.al_quran_android.activities.SurahDetailActivity;
import com.example.al_quran_android.adapter.SurahAdapter;
import com.example.al_quran_android.common.Common;
import com.example.al_quran_android.listener.SurahListener;
import com.example.al_quran_android.model.Surah;
import com.example.al_quran_android.viewmodel.SurahViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SurahListener {

    //Recyclerview implementation here...
    
    
    private RecyclerView recyclerView;
    private SurahViewModel surahViewModel;
    private SurahAdapter surahAdapter;
    private List<Surah> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        recyclerView = findViewById(R.id.surahRv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();

        surahViewModel = new ViewModelProvider(this).get(SurahViewModel.class);
        surahViewModel.getSurah().observe(this, surahResponse -> {
            for (int i = 0; i < surahResponse.getList().size(); i++) {
                list.add(new Surah(surahResponse.getList().get(i).getNumber(),
                        String.valueOf(surahResponse.getList().get(i).getName()),
                        String.valueOf(surahResponse.getList().get(i).getEnglishName()),
                        String.valueOf(surahResponse.getList().get(i).getEnglishNameTranslation()),
                        surahResponse.getList().get(i).getNumberOfAyahs(),
                        String.valueOf(surahResponse.getList().get(i).getRevelationType())
                ));
            }

            if (list.size() != 0) {
                surahAdapter = new SurahAdapter(this, list, this::onSurahListener);
                recyclerView.setAdapter(surahAdapter);
                surahAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onSurahListener(int position) {

        Intent intent = new Intent(MainActivity.this, SurahDetailActivity.class);
        intent.putExtra(Common.SURAH_NO, list.get(position).getNumber());
        intent.putExtra(Common.SURAH_NAME, list.get(position).getName());
        intent.putExtra(Common.SURAH_TRANSLATION, list.get(position).getEnglishNameTranslation());
        intent.putExtra(Common.SURAH_TYPE, list.get(position).getRevelationType());
        intent.putExtra(Common.SURAH_TOTAL_AYA, list.get(position).getNumberOfAyahs());

        startActivity(intent);

    }
}
