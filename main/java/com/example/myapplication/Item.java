package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Item {

    @SerializedName("poiId")
    @Expose
    private String poiId;
    @SerializedName("poiNm")
    @Expose
    private String poiNm;
    @SerializedName("gpsX")
    @Expose
    private String gpsX;
    @SerializedName("gpsY")
    @Expose
    private String gpsY;
    @SerializedName("posX")
    @Expose
    private String posX;
    @SerializedName("posY")
    @Expose
    private String posY;
    @SerializedName("addr")
    @Expose
    private Object addr;

    public String getPoiId() {
        return poiId;
    }

    public void setPoiId(String poiId) {
        this.poiId = poiId;
    }

    public String getPoiNm() {
        return poiNm;
    }

    public void setPoiNm(String poiNm) {
        this.poiNm = poiNm;
    }

    public String getGpsX() {
        return gpsX;
    }

    public void setGpsX(String gpsX) {
        this.gpsX = gpsX;
    }

    public String getGpsY() {
        return gpsY;
    }

    public void setGpsY(String gpsY) {
        this.gpsY = gpsY;
    }

    public String getPosX() {
        return posX;
    }

    public void setPosX(String posX) {
        this.posX = posX;
    }

    public String getPosY() {
        return posY;
    }

    public void setPosY(String posY) {
        this.posY = posY;
    }

    public Object getAddr() {
        return addr;
    }

    public void setAddr(Object addr) {
        this.addr = addr;
    }

}