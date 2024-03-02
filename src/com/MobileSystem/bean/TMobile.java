package com.MobileSystem.bean;

public class TMobile {
    private String Mobile_Number;
    private String Mobile_Type;
    private String Card_Number;
    private String Is_Available;
    private int Account_ID;

    public TMobile() {
    }

    public TMobile(String mobile_Number, String mobile_Type) {
        Mobile_Number = mobile_Number;
        Mobile_Type = mobile_Type;
    }

    public TMobile(String mobile_Number, String mobile_Type, String card_Number, String is_Available) {
        Mobile_Number = mobile_Number;
        Mobile_Type = mobile_Type;
        Card_Number = card_Number;
        Is_Available = is_Available;
    }

    public String getMobile_Number() {
        return Mobile_Number;
    }

    public void setMobile_Number(String mobile_Number) {
        Mobile_Number = mobile_Number;
    }

    public String getMobile_Type() {
        return Mobile_Type;
    }

    public void setMobile_Type(String mobile_Type) {
        Mobile_Type = mobile_Type;
    }

    public String getCard_Number() {
        return Card_Number;
    }

    public void setCard_Number(String card_Number) {
        Card_Number = card_Number;
    }

    public String getIs_Available() {
        return Is_Available;
    }

    public void setIs_Available(String is_Available) {
        Is_Available = is_Available;
    }

    public int getAccount_ID() {
        return Account_ID;
    }

    public void setAccount_ID(int account_ID) {
        Account_ID = account_ID;
    }
}
