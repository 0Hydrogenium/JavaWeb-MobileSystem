package com.MobileSystem.dao;

import com.MobileSystem.bean.TAccount;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModifyAccountDaoImpl implements ModifyAccountDao {
    @Override
    public SQLResult modifyAccount(TAccount tAccount) throws SQLException {
        int Account_ID = tAccount.getAccount_ID();

        SqlDriver sqlDriver = new SqlDriver();
        ResultSet rs;

        String sql = String.format(GlobalConst.SQL_SELECT_TACCOUNT, Account_ID);
        rs = sqlDriver.executeRead(sql);
        float old_Account_Balance = 0;
        if (rs.next()) {
            old_Account_Balance = rs.getFloat("Account_Balance");
        }
        else {
            return new SQLResult(false);
        }

        ArrayList<String> Charge_Code_list = new ArrayList<>();
        String sql_1 = String.format(GlobalConst.SQL_TCHARGE_RULE_Charge_Code);
        rs = sqlDriver.executeRead(sql_1);
        while (rs.next()) {
            Charge_Code_list.add(rs.getString("Charge_Code"));
        }

        float total_fee = 0;
        for (String x: Charge_Code_list) {
            String sql_4 = String.format(GlobalConst.SQL_SELECT_TCHARGE_Charge_Code, x);
            rs = sqlDriver.executeRead(sql_4);
            if (rs.next()) {
                total_fee += rs.getFloat("Charge");
            }
            else {
                return new SQLResult(false);
            }
        }

        String sql_2 = String.format(GlobalConst.SQL_UPDATE_TACCOUNT_Account_Balance, old_Account_Balance - total_fee, Account_ID);
        sqlDriver.executeWrite(sql_2);

        String sql_3 = String.format(GlobalConst.SQL_SELECT_TACCOUNT, Account_ID);
        rs = sqlDriver.executeRead(sql_3);
        TAccount tAccount_1 = null;
        if (rs.next()) {
            tAccount_1 = new TAccount();
            tAccount_1.setAccount_ID(rs.getInt("Account_ID"));
            tAccount_1.setContact_Person(rs.getString("Contact_Person"));
            tAccount_1.setContact_Address(rs.getString("Contact_Address"));
            tAccount_1.setAccount_Balance(rs.getFloat("Account_Balance"));
        }
        else {
            return new SQLResult(false);
        }

        return new SQLResult(true, "", tAccount_1);
    }
}
