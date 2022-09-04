package com.example.al_quran_android.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.al_quran_android.network.Api;
import com.example.al_quran_android.network.JsonPlaceHolderApi;
import com.example.al_quran_android.response.SurahResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurahRepo {

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    public SurahRepo(){
    jsonPlaceHolderApi = Api.getRetrofit().create(JsonPlaceHolderApi.class);
    }

    public LiveData<SurahResponse> getSurah(){
        MutableLiveData<SurahResponse> data = new MutableLiveData<>();
        jsonPlaceHolderApi.getSurah().enqueue(new Callback<SurahResponse>() {
            @Override
            public void onResponse(Call<SurahResponse> call, Response<SurahResponse> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<SurahResponse> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}
