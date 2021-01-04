package com.dina.pojo;
/**
 * @author xuhongda on 2021/1/3
 * com.dina.pojo
 * car-crash-animation
 * 轨迹点
 **/
public class Point {

    /*{
    "type": "GPS",
    "vid": "20042516273342108",
    "did": "47074800010",
    "lng": 114.07,
    "lat": 22.55,
    "dir": 0,
    "spd": 15,
    "t": "2020-12-23 17:25:30",
    "s": 1,
    "ts": 1608715530000,
    "xa": 0.009,
    "ya": -0.019,
    "za": -9.731,
    "yr": -0.2,
    "zr": 1.3,
    "xr": 279.3
}*/

    private String type;
    private String vid;
    private String did;
    private String lng;
    private String lat;
    private String dir;
    private String spd;
    private String t;
    private String s;
    private String ts;
    private String xa;
    private String ya;
    private String za;
    private String xr;
    private String yr;
    private String zr;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getSpd() {
        return spd;
    }

    public void setSpd(String spd) {
        this.spd = spd;
    }

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getXa() {
        return xa;
    }

    public void setXa(String xa) {
        this.xa = xa;
    }

    public String getYa() {
        return ya;
    }

    public void setYa(String ya) {
        this.ya = ya;
    }

    public String getZa() {
        return za;
    }

    public void setZa(String za) {
        this.za = za;
    }

    public String getXr() {
        return xr;
    }

    public void setXr(String xr) {
        this.xr = xr;
    }

    public String getYr() {
        return yr;
    }

    public void setYr(String yr) {
        this.yr = yr;
    }

    public String getZr() {
        return zr;
    }

    public void setZr(String zr) {
        this.zr = zr;
    }


    @Override
    public String toString() {
        return "Point{" +
                "type='" + type + '\'' +
                ", vid='" + vid + '\'' +
                ", did='" + did + '\'' +
                ", lng='" + lng + '\'' +
                ", lat='" + lat + '\'' +
                ", dir='" + dir + '\'' +
                ", spd='" + spd + '\'' +
                ", t='" + t + '\'' +
                ", s='" + s + '\'' +
                ", ts='" + ts + '\'' +
                ", xa='" + xa + '\'' +
                ", ya='" + ya + '\'' +
                ", za='" + za + '\'' +
                ", xr='" + xr + '\'' +
                ", yr='" + yr + '\'' +
                ", zr='" + zr + '\'' +
                '}';
    }
}
