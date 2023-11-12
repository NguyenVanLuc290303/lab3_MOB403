package com.example.lab3_mob403.modal;

public class androidVersion {
    String name;
    String ver;
    String api;

    public androidVersion() {
    }

    public androidVersion(String name, String ver, String api) {
        this.name = name;
        this.ver = ver;
        this.api = api;
    }

    public String getName() {
        return name;
    }

    public String getVer() {
        return ver;
    }

    public String getApi() {
        return api;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public void setApi(String api) {
        this.api = api;
    }
}
