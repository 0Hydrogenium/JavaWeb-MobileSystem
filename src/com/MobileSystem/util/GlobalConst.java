package com.MobileSystem.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.regex.Pattern;

public class GlobalConst {
    // 改进的FNV算法（哈希函数）
    public static String hashFunc(String data, int max_len) {
        final int p = 16777619;
        int hash = (int)2166136261L;

        for(int i=0;i<data.length();i++) {
            hash = (hash ^ data.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;

        // 过长的哈希码需要截断
        String hash_1 = String.valueOf(hash);
        if (hash_1.length() > max_len) {
            hash_1 = hash_1.substring(0, max_len);
        }

        return hash_1;
    }

    // 验证密码是否符合验证级别标准
    // SQLResult也可用于其他返回信息体
    public static SQLResult validateHigh(String passwords, String account) {
        if (Objects.equals(passwords, account)) {
            return new SQLResult(false, "ERROR:A");
        }

        if (passwords.length() < 8) {
            return new SQLResult(false, "ERROR:B");
        }

        Boolean integerMark = false;
        Boolean uppercaseMark = false;
        Boolean lowerMark = false;
        for (int i=0; i < passwords.length(); i++) {
            int ascNum = passwords.charAt(i);
            if (48 <= ascNum && ascNum <= 57) {
                integerMark = true;
            }
            else if (65 <= ascNum && ascNum <= 90) {
                uppercaseMark = true;
            }
            else if (97 <= ascNum && ascNum <= 122) {
                lowerMark = true;
            }
        }

        if (!integerMark) {
            return new SQLResult(false, "ERROR:C");
        }
        else if (!uppercaseMark) {
            return new SQLResult(false, "ERROR:D");
        }
        else if (!lowerMark) {
            return new SQLResult(false, "ERROR:E");
        }
        return new SQLResult(true);
    }

    // 判断字符串是否全为整数
    public static Boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    // 判断字符串是否为日期
    public static Boolean isDate(String str) {
        if (str.contains("-")) {
            String[] splitList = str.split("-");
            if (splitList.length == 3) {
                for (String x: splitList) {
                    if (!GlobalConst.isNumeric(x)) {
                        return false;
                    }
                }
                if ((1900 <= Integer.parseInt(splitList[0]) && Integer.parseInt(splitList[0]) <= 2100 &&
                        1 <= Integer.parseInt(splitList[1]) && Integer.parseInt(splitList[1]) <= 12 &&
                        1 <= Integer.parseInt(splitList[2]) && Integer.parseInt(splitList[2]) <= 31)) {
                    // 日期映射（月份->天数）
                    HashMap<String, Integer> monthToDayMapping = new HashMap<>();

                    monthToDayMapping.put("1", 31);
                    monthToDayMapping.put("3", 31);
                    monthToDayMapping.put("4", 30);
                    monthToDayMapping.put("5", 31);
                    monthToDayMapping.put("6", 30);
                    monthToDayMapping.put("7", 31);
                    monthToDayMapping.put("8", 31);
                    monthToDayMapping.put("9", 30);
                    monthToDayMapping.put("10", 31);
                    monthToDayMapping.put("11", 30);
                    monthToDayMapping.put("12", 31);

                    // 判断是否为闰年
                    if (Integer.parseInt(splitList[0]) % 4 == 0 &&
                            Integer.parseInt(splitList[0]) % 100 != 0 ||
                            Integer.parseInt(splitList[0]) % 400 == 0) {
                        monthToDayMapping.put("2", 29);
                    }
                    else {
                        monthToDayMapping.put("2", 28);
                    }

                    if (!(Integer.parseInt(splitList[2]) <= monthToDayMapping.get(splitList[1]))) {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }

        return true;
    }

    // 判断字符串是否为小数
    public static Boolean isDecimal(String str, String col) {
        if (str.contains(".")) {
            String[] splitList = str.split("\\.");
            if (splitList.length == 2) {
                for (String x: splitList) {
                    if (!GlobalConst.isNumeric(x)) {
                        return false;
                    }
                }

                if (Objects.equals(col, "Account_Balance")) {
                    if (splitList[0].length() >  10 || splitList[1].length() > 2) {
                        return false;
                    }
                }
                if (Objects.equals(col, "Charge")) {
                    if (Integer.parseInt(splitList[0]) >  6 || Integer.parseInt(splitList[1]) > 2) {
                        return false;
                    }
                }

            } else {
                return false;
            }
        } else {
            if (!isNumeric(str)) {
                return false;
            }
        }

        return true;
    }

    // 非法字符集
    public static final ArrayList<String> INVALID_CHAR = new ArrayList<>();

    // 数据库各字段的最大长度的映射（目前仅限整数，其他类型的数据为null）
    public static final HashMap<String, HashMap<String, Integer>> COL_TO_MAX_LEN = new HashMap<>();

    // "Charge_Code"到"Charge_Name"的映射 (字母->中文)
    public static final HashMap<String, String> Charge_Code_TO_Charge_Name = new HashMap<>();

    // "Func_ID"到"Func_Name"的映射 (字母->中文)
    public static final HashMap<String, String> Func_ID_TO_Func_Name = new HashMap<>();

    // 二单选按钮的映射
    public static final HashMap<String, String> TWO_TYPES_RADIO_MAPPING = new HashMap<>();

    static {
        INVALID_CHAR.add(" ");

        HashMap<String, Integer> TABLE_TO_COL;

        TABLE_TO_COL = new HashMap<>();
        TABLE_TO_COL.put("Account_ID", 8);
        TABLE_TO_COL.put("Contact_Person", 10);
        TABLE_TO_COL.put("Contact_Address", 50);
        TABLE_TO_COL.put("Account_Balance", null);
        COL_TO_MAX_LEN.put("TAccount", TABLE_TO_COL);

        TABLE_TO_COL = new HashMap<>();
        TABLE_TO_COL.put("Charge_Code", 1);
        TABLE_TO_COL.put("Charge_Name", 10);
        TABLE_TO_COL.put("Charge", null);
        COL_TO_MAX_LEN.put("TCharge", TABLE_TO_COL);

        TABLE_TO_COL = new HashMap<>();
        TABLE_TO_COL.put("Func_ID", 1);
        TABLE_TO_COL.put("Charge_Code", 1);
        TABLE_TO_COL.put("Func_Name", 10);
        COL_TO_MAX_LEN.put("TCharge_Rule", TABLE_TO_COL);

        TABLE_TO_COL = new HashMap<>();
        TABLE_TO_COL.put("Customer_ID", 8);
        TABLE_TO_COL.put("ID_Type", 1);
        TABLE_TO_COL.put("ID_Number", 20);
        TABLE_TO_COL.put("Customer_Name", 20);
        TABLE_TO_COL.put("Customer_Birthday", null);
        TABLE_TO_COL.put("Customer_Sex", 2);
        TABLE_TO_COL.put("Customer_Address", 50);
        COL_TO_MAX_LEN.put("TCustomer", TABLE_TO_COL);

        TABLE_TO_COL = new HashMap<>();
        TABLE_TO_COL.put("Mobile_Number", 11);
        TABLE_TO_COL.put("Mobile_Type", 3);
        TABLE_TO_COL.put("Card_Number", 13);
        TABLE_TO_COL.put("Is_Available", 1);
        COL_TO_MAX_LEN.put("TMobile", TABLE_TO_COL);

        TABLE_TO_COL = new HashMap<>();
        TABLE_TO_COL.put("Operator_ID", 10);
        TABLE_TO_COL.put("Operator_Name", 20);
        TABLE_TO_COL.put("Operator_Pwd", 20);
        TABLE_TO_COL.put("Is_Admin", 1);
        COL_TO_MAX_LEN.put("TOperator", TABLE_TO_COL);

        TABLE_TO_COL = new HashMap<>();
        TABLE_TO_COL.put("User_ID", 8);
        TABLE_TO_COL.put("Account_ID", 8);
        TABLE_TO_COL.put("Mobile_Number", 11);
        TABLE_TO_COL.put("Customer_ID", 8);
        TABLE_TO_COL.put("Roaming_Status", 1);
        TABLE_TO_COL.put("Com_Level", 1);
        COL_TO_MAX_LEN.put("TUser", TABLE_TO_COL);


        Charge_Code_TO_Charge_Name.put("A", "开户费");
        Charge_Code_TO_Charge_Name.put("B", "漫游费");
        Charge_Code_TO_Charge_Name.put("C", "押金");
        Charge_Code_TO_Charge_Name.put("D", "入网费");
        Charge_Code_TO_Charge_Name.put("E", "选号费");


        Func_ID_TO_Func_Name.put("O", "开户");


        TWO_TYPES_RADIO_MAPPING.put("V1", "Y");
        TWO_TYPES_RADIO_MAPPING.put("V2", "N");
    }

    // SQL: 判断操作员的用户名是否存在
    public static final String SQL_SELECT_TOPERATOR_Operator_ID = "select * from TOperator where Operator_ID = '%s'";

    // SQL: 判断操作员的用户名和密码是否正确
    public static final String SQL_SELECT_TOPERATOR_LOGIN = "select * from TOperator where Operator_ID = '%s' and Operator_Pwd = '%s'";

    // SQL: 更新操作员的信息
    public static final String SQL_UPDATE_TOPERATOR = "update TOperator set Operator_Name = '%s', Operator_Pwd = '%s', Is_Admin = '%s' where Operator_ID = '%s'";

    //SQL: 查看所有操作员的信息
    public static final String SQL_SELECT_TOPERATOR_ALL = "select * from TOperator";

    //SQL: 删除操作员
    public static final String SQL_DELETE_TOPERATOR = "delete from TOperator where Operator_ID = '%s'";

    //SQL: 添加新的操作员
    public static final String SQL_INSERT_TOPERATOR = "insert into TOperator value('%s', '%s', '%s', '%s')";

    //SQL: 查看特定账号的信息
    public static final String SQL_SELECT_TACCOUNT = "select * from TAccount where Account_ID = %d";

    //SQL: 更新账号的金额
    public static final String SQL_UPDATE_TACCOUNT_Account_Balance = "update TAccount set Account_Balance = %f where Account_ID = %d";

    //SQL: 获取Charge.Charge_Code的金额
    public static final String SQL_SELECT_TCHARGE_Charge_Code = "select * from TCharge where Charge_Code = '%s'";

    //SQL: 添加新的账号信息
    public static final String SQL_INSERT_TACCOUNT = "insert into TAccount value(%d, '%s', '%s', %f)";

    //SQL: 获取电话号码的特定信息
    public static final String SQL_SELECT_TMOBILE_Mobile_Number = "select * from TMobile where Mobile_Number = '%s'";

    //SQL: 获取电话号码的最大分组数
    public static final String SQL_SELECT_TMOBILE_MAX_NUM = "select max(Card_Number) num from TMobile";

    //SQL: 添加新的电话号码
    public static final String SQL_INSERT_TMOBILE = "insert into TMobile value('%s', '%s', '%s', '%s')";

    //SQL: 获取业务收费的所有收费项目的Charge_Code
    public static final String SQL_TCHARGE_RULE_Charge_Code = "select Charge_Code from TCharge_Rule";

    //SQL: 获取特定客户的信息
    public static final String SQL_SELECT_TCUSTOMER = "select * from TCustomer where ID_Type = '%s' and ID_Number = '%s'";

    //SQL: 获取用户最大的ID
    public static final String SQL_SELECT_TUSER_MAX_NUM = "select max(User_ID) num from TUser";

    //SQL: 添加新的用户
    public static final String SQL_INSERT_TUSER = "insert into TUser value('%d', %d, '%s', '%d', '%s', '%s')";

    //SQL: 获取顾客最大的ID
    public static final String SQL_SELECT_TCUSTOMER_MAX_NUM = "select max(Customer_ID) num from TCustomer";

    //SQL: 添加新的顾客
    public static final String SQL_INSERT_TCUSTOMER = "insert into TCustomer value(%d, '%s', '%s', '%s', '%s', '%s', '%s')";

    //SQL: 更新收费细项的信息
    public static final String SQL_UPDATE_TCHARGE = "update TCharge set Charge_Name='%s', Charge=%f where Charge_Code='%s'";

    //SQL: 删除所有业务收费规则
    public static final String SQL_DELETE_TCHARGE_RULE_ALL = "delete from TCharge_Rule";

    //SQL: 添加新的业务收费规则
    public static final String SQL_INSERT_TCHARGE_RULE = "insert into TCharge_Rule value('%s', '%s', '%s')";

    //SQL: 查看所有电话号码的信息
    public static final String SQL_SELECT_TMOBILE_ALL = "select * from TMobile";

    //SQL: 获取特定用户的信息
    public static final String SQL_SELECT_TUSER_Account_ID = "select * from TUser where Mobile_Number = %s";

    //SQL: 使手机号码无法获取
    public static final String SQL_UPDATE_TMOBILE_Is_Available = "update TMobile set Is_Available = '%s' where Mobile_Number = '%s'";

}
