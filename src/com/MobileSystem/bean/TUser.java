package com.MobileSystem.bean;

public class TUser {
    private int User_ID;
    private int Account_ID;
    private String Mobile_Number;
    private int Customer_ID;
    private String Roaming_Status;
    private String Com_Level;

    public TUser() {
    }

    public TUser(int account_ID, String mobile_Number, int customer_ID, String roaming_Status, String com_Level) {
        Account_ID = account_ID;
        Mobile_Number = mobile_Number;
        Customer_ID = customer_ID;
        Roaming_Status = roaming_Status;
        Com_Level = com_Level;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public int getAccount_ID() {
        return Account_ID;
    }

    public void setAccount_ID(int account_ID) {
        Account_ID = account_ID;
    }

    public String getMobile_Number() {
        return Mobile_Number;
    }

    public void setMobile_Number(String mobile_Number) {
        Mobile_Number = mobile_Number;
    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public String getRoaming_Status() {
        return Roaming_Status;
    }

    public void setRoaming_Status(String roaming_Status) {
        Roaming_Status = roaming_Status;
    }

    public String getCom_Level() {
        return Com_Level;
    }

    public void setCom_Level(String com_Level) {
        Com_Level = com_Level;
    }
}
