package com.example.al_quran_android.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.al_quran_android.repository.SurahRepo;
import com.example.al_quran_android.response.SurahResponse;

public class SurahViewModel extends ViewModel {
    private SurahRepo surahRepo;

    public SurahViewModel (){
        surahRepo = new SurahRepo();
    }

    public LiveData<SurahResponse> getSurah(){
        return surahRepo.getSurah();
    }
}
