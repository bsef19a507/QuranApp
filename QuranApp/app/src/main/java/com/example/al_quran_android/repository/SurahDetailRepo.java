package com.example.al_quran_android.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.al_quran_android.network.Api;
import com.example.al_quran_android.network.JsonPlaceHolderApi;
import com.example.al_quran_android.response.SurahDetailResponse;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurahDetailRepo {

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    public SurahDetailRepo() {
        jsonPlaceHolderApi = Api.getInstance().create(JsonPlaceHolderApi.class);
    }

    public LiveData<SurahDetailResponse> getSurahDetail(String lan, int id) {

        MutableLiveData<SurahDetailResponse> data = new MutableLiveData<>();
        jsonPlaceHolderApi.getSurahDetail(lan, id).enqueue(new Callback<SurahDetailResponse>() {
            @Override
            public void onResponse(Call<SurahDetailResponse> call, Response<SurahDetailResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SurahDetailResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

}
