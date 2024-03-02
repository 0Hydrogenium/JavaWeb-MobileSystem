package com.MobileSystem.bean;

public class TOperator {
    private String Operator_ID;
    private String Operator_Name;
    private String Operator_Pwd;
    private String Is_Admin;

    public TOperator() {
    }

    public TOperator(String operator_ID, String operator_Pwd) {
        Operator_ID = operator_ID;
        Operator_Pwd = operator_Pwd;
    }

    public TOperator(String operator_ID, String operator_Name, String operator_Pwd, String is_Admin) {
        Operator_ID = operator_ID;
        Operator_Name = operator_Name;
        Operator_Pwd = operator_Pwd;
        Is_Admin = is_Admin;
    }

    public String getOperator_ID() {
        return Operator_ID;
    }

    public void setOperator_ID(String operator_ID) {
        Operator_ID = operator_ID;
    }

    public String getOperator_Name() {
        return Operator_Name;
    }

    public void setOperator_Name(String operator_Name) {
        Operator_Name = operator_Name;
    }

    public String getOperator_Pwd() {
        return Operator_Pwd;
    }

    public void setOperator_Pwd(String operator_Pwd) {
        Operator_Pwd = operator_Pwd;
    }

    public String getIs_Admin() {
        return Is_Admin;
    }

    public void setIs_Admin(String is_Admin) {
        Is_Admin = is_Admin;
    }
}
