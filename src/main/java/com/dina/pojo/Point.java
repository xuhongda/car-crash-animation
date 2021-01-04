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
    private String collisionAngle;
    private String collisionType;
    private String type;
    private String vid;
    private String did;
    private Double lng;
    private Double lat;
    private Double dir;
    private Double spd;
    private String t;
    private String s;
    private Double ts;
    private Double xa;
    private Double ya;
    private Double za;
    private Double xr;
    private Double yr;
    private Double zr;

    public String getCollisionAngle() {
        return collisionAngle;
    }

    public void setCollisionAngle(String collisionAngle) {
        this.collisionAngle = collisionAngle;
    }

    public String getCollisionType() {
        return collisionType;
    }

    public void setCollisionType(String collisionType) {
        this.collisionType = collisionType;
    }

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

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getDir() {
        return dir;
    }

    public void setDir(Double dir) {
        this.dir = dir;
    }

    public Double getSpd() {
        return spd;
    }

    public void setSpd(Double spd) {
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

    public Double getTs() {
        return ts;
    }

    public void setTs(Double ts) {
        this.ts = ts;
    }

    public Double getXa() {
        return xa;
    }

    public void setXa(Double xa) {
        this.xa = xa;
    }

    public Double getYa() {
        return ya;
    }

    public void setYa(Double ya) {
        this.ya = ya;
    }

    public Double getZa() {
        return za;
    }

    public void setZa(Double za) {
        this.za = za;
    }

    public Double getXr() {
        return xr;
    }

    public void setXr(Double xr) {
        this.xr = xr;
    }

    public Double getYr() {
        return yr;
    }

    public void setYr(Double yr) {
        this.yr = yr;
    }

    public Double getZr() {
        return zr;
    }

    public void setZr(Double zr) {
        this.zr = zr;
    }


    @Override
    public String toString() {
        return "Point{" +
                "type='" + type + '\'' +
                ", vid='" + vid + '\'' +
                ", did='" + did + '\'' +
                ", lng=" + lng +
                ", lat=" + lat +
                ", dir=" + dir +
                ", spd=" + spd +
                ", t='" + t + '\'' +
                ", s='" + s + '\'' +
                ", ts=" + ts +
                ", xa=" + xa +
                ", ya=" + ya +
                ", za=" + za +
                ", xr=" + xr +
                ", yr=" + yr +
                ", zr=" + zr +
                '}';
    }
}
