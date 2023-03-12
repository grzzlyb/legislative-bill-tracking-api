package com.grzzlyb.springrest.entity;

public class Bill {

    private String billName;
    private String billStatus;

    public Bill() {}

    public Bill(String billName, String billStatus) {
        this.billName = billName;
        this.billStatus = billStatus;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(String billStatus) {
        this.billStatus = billStatus;
    }
}
