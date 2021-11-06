package com.listofusers.sring.rest.exeptions;

public class IncorrectUser {

    private String info;

    public IncorrectUser(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
