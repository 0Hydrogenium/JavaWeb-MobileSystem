package com.MobileSystem.bean;

public class TAccount {
    private int Account_ID;
    private String Contact_Person;
    private String Contact_Address;
    private float Account_Balance;

    public TAccount() {
    }

    public TAccount(int account_ID) {
        Account_ID = account_ID;
    }

    public TAccount(int account_ID, String contact_Person, String contact_Address, float account_Balance) {
        Account_ID = account_ID;
        Contact_Person = contact_Person;
        Contact_Address = contact_Address;
        Account_Balance = account_Balance;
    }

    public int getAccount_ID() {
        return Account_ID;
    }

    public void setAccount_ID(int account_ID) {
        Account_ID = account_ID;
    }

    public String getContact_Person() {
        return Contact_Person;
    }

    public void setContact_Person(String contact_Person) {
        Contact_Person = contact_Person;
    }

    public String getContact_Address() {
        return Contact_Address;
    }

    public void setContact_Address(String contact_Address) {
        Contact_Address = contact_Address;
    }

    public float getAccount_Balance() {
        return Account_Balance;
    }

    public void setAccount_Balance(float account_Balance) {
        Account_Balance = account_Balance;
    }
}
