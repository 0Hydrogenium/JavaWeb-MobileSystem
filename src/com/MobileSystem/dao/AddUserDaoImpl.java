package com.MobileSystem.dao;

import com.MobileSystem.bean.TUser;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddUserDaoImpl implements AddUserDao {
    @Override
    public SQLResult addUser(TUser tUser) throws SQLException {
        int Account_ID = tUser.getAccount_ID();
        String Mobile_Number = tUser.getMobile_Number();
        int Customer_ID = tUser.getCustomer_ID();
        String Roaming_Status = tUser.getRoaming_Status();
        String Com_Level = tUser.getCom_Level();

        SqlDriver sqlDriver = new SqlDriver();

        ResultSet rs;
        String sql_2 = String.format(GlobalConst.SQL_SELECT_TMOBILE_Mobile_Number, Mobile_Number);
        rs = sqlDriver.executeRead(sql_2);

        if (!rs.next()) {
            return new SQLResult(false, "ERROR:0");
        }

        int max_User_ID = 0;
        ResultSet rs_0 = null;
        String sql_0 = GlobalConst.SQL_SELECT_TUSER_MAX_NUM;
        rs_0 = sqlDriver.executeRead(sql_0);

        while (rs_0.next()) {
            max_User_ID = rs_0.getInt("num");
        }

        String sql_1 = String.format(GlobalConst.SQL_INSERT_TUSER, max_User_ID+1, Account_ID, Mobile_Number, Customer_ID, Roaming_Status, Com_Level);
        sqlDriver.executeWrite(sql_1);

        String sql_4 = String.format(GlobalConst.SQL_UPDATE_TMOBILE_Is_Available, "N", Mobile_Number);
        sqlDriver.executeWrite(sql_4);

        ResultSet rs_1;
        String sql_3 = String.format(GlobalConst.SQL_SELECT_TACCOUNT, Account_ID);
        rs_1 = sqlDriver.executeRead(sql_3);

        if (!rs_1.next()) {
            return new SQLResult(false, "ERROR:1");
        }

        return new SQLResult(true);
    }
}
