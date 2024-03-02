package com.MobileSystem.dao;

import com.MobileSystem.bean.TCustomer;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddCustomerDaoImpl implements AddCustomerDao {
    @Override
    public SQLResult AddCustomer(TCustomer tCustomer) throws SQLException {
        String ID_Type = tCustomer.getID_Type();
        String ID_Number = tCustomer.getID_Number();
        String Customer_Name = tCustomer.getCustomer_Name();
        String Customer_Birthday = tCustomer.getCustomer_Birthday();
        String Customer_Sex = tCustomer.getCustomer_Sex();
        String Customer_Address = tCustomer.getCustomer_Address();

        SqlDriver sqlDriver = new SqlDriver();

        int max_Customer_ID = 0;
        ResultSet rs_0;
        String sql_0 = GlobalConst.SQL_SELECT_TCUSTOMER_MAX_NUM;
        rs_0 = sqlDriver.executeRead(sql_0);

        while (rs_0.next()) {
            max_Customer_ID = rs_0.getInt("num");
        }

        TCustomer tCustomer_1 = new TCustomer();
        tCustomer_1.setCustomer_ID(max_Customer_ID+1);

        String sql_1 = String.format(GlobalConst.SQL_INSERT_TCUSTOMER,
                max_Customer_ID+1, ID_Type, ID_Number, Customer_Name, Customer_Birthday, Customer_Sex, Customer_Address);
        sqlDriver.executeWrite(sql_1);

        return new SQLResult(true, "", tCustomer_1);
    }
}
