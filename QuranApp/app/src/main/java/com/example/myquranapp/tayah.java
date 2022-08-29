package com.example.myquranapp;

public class tayah {
    private int AyaID;
    private int SurahID;
    private int AyahNo;
    private String ArabicText;
    private String FatehMuhammadJaland;
    private String MehmoodulHassan;
    private String DrMohsinKhan;
    private String MuftitakiUsmani;
    private int RukuID;
    private int PRakuID;
    private int ParaID;

    @Override
    public String toString() {
        return "tayah{" +
                "AyaID=" + AyaID +
                ", SurahID=" + SurahID +
                ", AyahNo=" + AyahNo +
                ", ArabicText='" + ArabicText + '\'' +
                ", FatehMuhammadJaland='" + FatehMuhammadJaland + '\'' +
                ", MehmoodulHassan='" + MehmoodulHassan + '\'' +
                ", DrMohsinKhan='" + DrMohsinKhan + '\'' +
                ", MuftitakiUsmani='" + MuftitakiUsmani + '\'' +
                ", RukuID=" + RukuID +
                ", PRakuID=" + PRakuID +
                ", ParaID=" + ParaID +
                '}';
    }

    public tayah(int ayaID, int surahID, int ayahNo, String arabicText, String fatehMuhammadJaland, String mehmoodulHassan, String drMohsinKhan, String muftitakiUsmani, int rukuID, int PRakuID, int paraID) {
        AyaID = ayaID;
        SurahID = surahID;
        AyahNo = ayahNo;
        ArabicText = arabicText;
        FatehMuhammadJaland = fatehMuhammadJaland;
        MehmoodulHassan = mehmoodulHassan;
        DrMohsinKhan = drMohsinKhan;
        MuftitakiUsmani = muftitakiUsmani;
        RukuID = rukuID;
        this.PRakuID = PRakuID;
        ParaID = paraID;
    }

    public int getAyaID() {
        return AyaID;
    }

    public int getSurahID() {
        return SurahID;
    }

    public int getAyahNo() {
        return AyahNo;
    }

    public String getArabicText() {
        return ArabicText;
    }

    public String getFatehMuhammadJaland() {
        return FatehMuhammadJaland;
    }

    public String getMehmoodulHassan() {
        return MehmoodulHassan;
    }

    public String getDrMohsinKhan() {
        return DrMohsinKhan;
    }

    public String getMuftitakiUsmani() {
        return MuftitakiUsmani;
    }

    public int getRukuID() {
        return RukuID;
    }

    public int getPRakuID() {
        return PRakuID;
    }

    public int getParaID() {
        return ParaID;
    }
}
