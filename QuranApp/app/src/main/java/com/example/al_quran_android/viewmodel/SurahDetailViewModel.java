package com.example.al_quran_android.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.al_quran_android.repository.SurahDetailRepo;
import com.example.al_quran_android.response.SurahDetailResponse;

public class SurahDetailViewModel extends ViewModel {
    private SurahDetailRepo surahDetailRepo;

    public SurahDetailViewModel() {
        surahDetailRepo = new SurahDetailRepo();
    }

    public LiveData<SurahDetailResponse> getSurahDetail(String lan, int id) {
        return surahDetailRepo.getSurahDetail(lan, id);
    }
}
