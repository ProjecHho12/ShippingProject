package com.hoho.shipping.employee;

public class Journal {
    private String parcelId;
    private String parcelStatus;
    private String employeeName;

    public Journal(String parcelId, String parcelStatus, String employeeName) {
        this.parcelId = parcelId;
        this.parcelStatus = parcelStatus;
        this.employeeName = employeeName;
    }

    public String setJournal(){
        return String.format("운송장 번호: " + this.parcelId + "택배를 "+ this.parcelStatus + "했습니다. 직원: "+ this.employeeName);
    }



}
