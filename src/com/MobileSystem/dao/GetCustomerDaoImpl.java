package com.MobileSystem.dao;

import com.MobileSystem.bean.TCustomer;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GetCustomerDaoImpl implements GetCustomerDao {
    @Override
    public SQLResult getCustomer(TCustomer tCustomer) throws SQLException {
        String ID_Type = tCustomer.getID_Type();
        String ID_Number = tCustomer.getID_Number();

        SqlDriver sqlDriver = new SqlDriver();
        ResultSet rs = null;
        String sql = String.format(GlobalConst.SQL_SELECT_TCUSTOMER, ID_Type, ID_Number);
        rs = sqlDriver.executeRead(sql);

        if (rs.next()) {
            TCustomer tCustomer_1 = new TCustomer();
            tCustomer_1.setID_Type(rs.getString("ID_Type"));
            tCustomer_1.setID_Number(rs.getString("ID_Number"));
            tCustomer_1.setCustomer_Name(rs.getString("Customer_Name"));
            tCustomer_1.setCustomer_Birthday(rs.getString("Customer_Birthday"));
            tCustomer_1.setCustomer_Sex(rs.getString("Customer_Sex"));
            tCustomer_1.setCustomer_Address(rs.getString("Customer_Address"));

            return new SQLResult(true, "", tCustomer_1);
        }

        return new SQLResult(false);
    }
}
