package com.MobileSystem.dao;

import com.MobileSystem.bean.TMobile;
import com.MobileSystem.bean.TOperator;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisplayMobilesDaoImpl implements DisplayMobilesDao {
    @Override
    public SQLResult getMobiles() throws SQLException {
        ArrayList<TMobile> arrayList = new ArrayList<>();

        SqlDriver sqlDriver = new SqlDriver();
        String sql = GlobalConst.SQL_SELECT_TMOBILE_ALL;
        TMobile tMobile;
        ResultSet rs;
        rs = sqlDriver.executeRead(sql);

        while (rs.next()) {
            tMobile = new TMobile();
            String Mobile_Number = rs.getString("Mobile_Number");
            tMobile.setMobile_Number(Mobile_Number);
            tMobile.setMobile_Type(rs.getString("Mobile_Type"));
            tMobile.setCard_Number(rs.getString("Card_Number"));
            tMobile.setIs_Available(rs.getString("Is_Available"));

            ResultSet rs_1;
            String sql_1 = String.format(GlobalConst.SQL_SELECT_TUSER_Account_ID, Mobile_Number);
            rs_1 = sqlDriver.executeRead(sql_1);
            if (rs_1.next()) {
                tMobile.setAccount_ID(rs_1.getInt("Account_ID"));
            }

            arrayList.add(tMobile);
        }

        return new SQLResult(true, "", arrayList);
    }
}
