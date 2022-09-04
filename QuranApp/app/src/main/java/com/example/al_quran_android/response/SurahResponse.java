package com.example.al_quran_android.response;

import com.example.al_quran_android.model.Surah;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SurahResponse {

    @SerializedName("data")
    private List<Surah>  list;

    public List<Surah> getList() {
        return list;
    }

    public void setList(List<Surah> list) {
        this.list = list;
    }
}
