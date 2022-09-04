package com.example.al_quran_android.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.al_quran_android.R;
import com.example.al_quran_android.adapter.SurahDetailAdapter;
import com.example.al_quran_android.common.Common;
import com.example.al_quran_android.model.SurahDetail;
import com.example.al_quran_android.viewmodel.SurahDetailViewModel;

import java.util.ArrayList;
import java.util.List;

public class SurahDetailActivity extends AppCompatActivity {

    private TextView surahName, surahType, surahTranslation;
    private int no;
    private RecyclerView recyclerView;
    private List<SurahDetail> list;
    private SurahDetailAdapter adapter;
    private SurahDetailViewModel surahDetailViewModel;
    String urdu = "urdu_junagarhi";
    String english = "english_hilali_khan";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_detail);

        init();

        String type = getIntent().getStringExtra(Common.SURAH_TYPE).equals("Meccan") ? "Makki Surah" : "Madani Surah";

        no = getIntent().getIntExtra(Common.SURAH_NO, 0);
        surahName.setText(getIntent().getStringExtra(Common.SURAH_NAME));
        surahType.setText(type);
        surahTranslation.setText(getIntent().getStringExtra(Common.SURAH_TRANSLATION));


        recyclerView.setHasFixedSize(true);
        list = new ArrayList<>();

        surahTranslation(urdu, no);



    }

    private void filter(String id) {
        ArrayList<SurahDetail> arrayList = new ArrayList<>();
        for (SurahDetail detail : list) {
            if (String.valueOf(detail.getId()).contains(id)) {
                arrayList.add(detail);
            }
        }
        adapter.filter(arrayList);
    }

    private void init() {
        surahName = findViewById(R.id.surah_name);
        surahType = findViewById(R.id.Type);
        surahTranslation = findViewById(R.id.translation);
        recyclerView = findViewById(R.id.surah_detail_rv);

    }

    private void surahTranslation(String lan, int id) {

        if (list.size() > 0) {
            list.clear();
        }
        surahDetailViewModel = new ViewModelProvider(this).get(SurahDetailViewModel.class);

        surahDetailViewModel.getSurahDetail(lan, id).observe(this, surahDetailResponse -> {

            for (int i = 0; i < surahDetailResponse.getList().size(); i++) {
                list.add(new SurahDetail(surahDetailResponse.getList().get(i).getId(),
                        surahDetailResponse.getList().get(i).getSura(),
                        surahDetailResponse.getList().get(i).getAya(),
                        surahDetailResponse.getList().get(i).getArabic_text(),
                        surahDetailResponse.getList().get(i).getTranslation(),
                        surahDetailResponse.getList().get(i).getFootnotes()));
            }

            if (list.size() != 0) {
                adapter = new SurahDetailAdapter(this, list);
                System.out.println(adapter);
                recyclerView.setAdapter(adapter);

            }
        });
    }
}