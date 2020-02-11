package com.lucaryholt.ipinfojava.Model;

public class IPInfoHolder {

    private String location;
    private String postal;
    private String city;
    private String ip;

    public IPInfoHolder(String location, String postal, String city, String ip) {
        this.location = location;
        this.postal = postal;
        this.city = city;
        this.ip = ip;
    }

    public IPInfoHolder() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
