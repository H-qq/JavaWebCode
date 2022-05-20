package com.signin.beans;

public class Record {
    private String date_time;
    private String name;
    private String temp;
    private String location;

    public Record() {

    }

    public Record(String date_time, String name, String temp, String location) {
        this.date_time = date_time;
        this.name = name;
        this.temp = temp;
        this.location = location;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getTemp() {
        return temp;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
