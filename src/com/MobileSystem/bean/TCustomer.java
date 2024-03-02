package com.MobileSystem.bean;

public class TCustomer {
    private int Customer_ID;
    private String ID_Type;
    private String ID_Number;
    private String Customer_Name;
    private String Customer_Birthday;
    private String Customer_Sex;
    private String Customer_Address;

    public TCustomer() {
    }

    public TCustomer(String ID_Type, String ID_Number) {
        this.ID_Type = ID_Type;
        this.ID_Number = ID_Number;
    }

    public TCustomer(String ID_Type, String ID_Number, String customer_Name, String customer_Birthday, String customer_Sex, String customer_Address) {
        this.ID_Type = ID_Type;
        this.ID_Number = ID_Number;
        Customer_Name = customer_Name;
        Customer_Birthday = customer_Birthday;
        Customer_Sex = customer_Sex;
        Customer_Address = customer_Address;
    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public String getID_Type() {
        return ID_Type;
    }

    public void setID_Type(String ID_Type) {
        this.ID_Type = ID_Type;
    }

    public String getID_Number() {
        return ID_Number;
    }

    public void setID_Number(String ID_Number) {
        this.ID_Number = ID_Number;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getCustomer_Birthday() {
        return Customer_Birthday;
    }

    public void setCustomer_Birthday(String customer_Birthday) {
        Customer_Birthday = customer_Birthday;
    }

    public String getCustomer_Sex() {
        return Customer_Sex;
    }

    public void setCustomer_Sex(String customer_Sex) {
        Customer_Sex = customer_Sex;
    }

    public String getCustomer_Address() {
        return Customer_Address;
    }

    public void setCustomer_Address(String customer_Address) {
        Customer_Address = customer_Address;
    }
}
