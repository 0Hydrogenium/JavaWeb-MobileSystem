package com.MobileSystem.dao;

import com.MobileSystem.bean.TAccount;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddAccountDaoImpl implements AddAccountDao {
    @Override
    public SQLResult addAccount(TAccount tAccount) throws SQLException {
        int Account_ID = tAccount.getAccount_ID();
        String Contact_Person = tAccount.getContact_Person();
        String Contact_Address = tAccount.getContact_Address();
        float Account_Balance = tAccount.getAccount_Balance();

        SqlDriver sqlDriver = new SqlDriver();

        String sql_1 = String.format(GlobalConst.SQL_INSERT_TACCOUNT, Account_ID, Contact_Person, Contact_Address, Account_Balance);
        sqlDriver.executeWrite(sql_1);

        return new SQLResult(true);
    }
}
