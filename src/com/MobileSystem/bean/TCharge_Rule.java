package com.MobileSystem.bean;

public class TCharge_Rule {
    private String Func_ID;
    private String Charge_Code;
    private String Func_Name;

    public TCharge_Rule() {
    }

    public TCharge_Rule(String func_ID, String charge_Code, String func_Name) {
        Func_ID = func_ID;
        Charge_Code = charge_Code;
        Func_Name = func_Name;
    }

    public String getFunc_ID() {
        return Func_ID;
    }

    public void setFunc_ID(String func_ID) {
        Func_ID = func_ID;
    }

    public String getCharge_Code() {
        return Charge_Code;
    }

    public void setCharge_Code(String charge_Code) {
        Charge_Code = charge_Code;
    }

    public String getFunc_Name() {
        return Func_Name;
    }

    public void setFunc_Name(String func_Name) {
        Func_Name = func_Name;
    }
}
