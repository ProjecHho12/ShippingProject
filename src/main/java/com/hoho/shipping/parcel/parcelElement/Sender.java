package com.hoho.shipping.parcel.parcelElement;

import com.hoho.shipping.parcel.StringInput;

import java.io.Serializable;

public class Sender extends PersonInfo implements InformationCheck<PersonInfo>, Serializable {
    private static final long serialVersionUID = 1L;

    StringInput si;

    public Sender(String name, String number, Address address) {
        super(name, number, address);
    }

    public Sender(StringInput si) {
        super();
        this.si = new StringInput();
    }



    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getNumber() {
        return super.getNumber();
    }

    @Override
    public Address getAddress() {
        return super.getAddress();
    }

    @Override
    public void setAddress(Address address) {
        super.setAddress(address);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setNumber(String number) {
        super.setNumber(number);
    }

    @Override
    public PersonInfo executeInputMethods(StringInput si) {
        super.executeInputMethods(si);
        this.getAddress().setState(getAddress().getState());
        //getAddress().setState(getAddress().getState());
        getAddress().setCity(getAddress().getCity());
        getAddress().setStreetAddress(getAddress().getStreetAddress());
        getAddress().setZipPostalCode(getAddress().getZipPostalCode());
        return this;
    }

    @Override
    public PersonInfo CheckTarget() {
        // 보내는 사람 정보
        System.out.println("* 보내는 분 - 보내시는 고객님의 정보를 정확히 입력해 주세요.");
        return executeInputMethods(si);
    }

    @Override
    public PersonInfo checkInfo() {
        InformationCheck.super.checkInfo();
        return this;
    }
}
