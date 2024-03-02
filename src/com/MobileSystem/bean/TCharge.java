package com.MobileSystem.bean;

public class TCharge {
    private String Charge_Code;
    private String Charge_Name;
    private float Charge;

    public TCharge() {
    }

    public TCharge(String charge_Code, String charge_Name, float charge) {
        Charge_Code = charge_Code;
        Charge_Name = charge_Name;
        Charge = charge;
    }

    public String getCharge_Code() {
        return Charge_Code;
    }

    public void setCharge_Code(String charge_Code) {
        Charge_Code = charge_Code;
    }

    public String getCharge_Name() {
        return Charge_Name;
    }

    public void setCharge_Name(String charge_Name) {
        Charge_Name = charge_Name;
    }

    public float getCharge() {
        return Charge;
    }

    public void setCharge(float charge) {
        Charge = charge;
    }
}
