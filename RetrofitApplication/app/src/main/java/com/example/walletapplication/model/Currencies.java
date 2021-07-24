package com.example.walletapplication.model;

import com.example.walletapplication.pojo.MultipleResource;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Currencies {

    @SerializedName("id")
    @Expose
    public  Integer sId;
    @SerializedName("symbol")
    @Expose
    public  String sSymbol;
    @SerializedName("name")
    @Expose
    public  String sName;
    @SerializedName("currency_type")
    @Expose
    public  String sCurrencyType;
    @SerializedName("icon_path")
    @Expose
    public  String sIconPath;

    public Currencies(Integer sId, String sName, String sSymbol, String sCurrencyType, String sIconPath) {
        this.sId = sId;
        this.sName = sName;
        this.sSymbol = sSymbol;
        this.sCurrencyType = sCurrencyType;
        this.sIconPath = sIconPath;
    }

    public Integer getId() {
        return sId;
    }

    public void setId(Integer sId) {
        this.sId = sId;
    }

    public String getSymbol() {
        return sSymbol;
    }

    public void setSymbol(String sSymbol) {
        this.sSymbol = sSymbol;
    }

    public String getName() {
        return sName;
    }

    public void setName(String sName) {
        this.sName = sName;
    }

    public String getType() {
        return sCurrencyType;
    }

    public void setType(String sType) {
        this.sCurrencyType = sCurrencyType;
    }

    public String getIconPath() {
        return sIconPath;
    }

    public void setIconPath(String sIconPath) {
        this.sIconPath = sIconPath;
    }
}
