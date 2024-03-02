package com.MobileSystem.dao;

import com.MobileSystem.bean.TMobile;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AddMobilesDaoImpl implements AddMobilesDao {
    @Override
    public SQLResult addMobiles(ArrayList<TMobile> arrayList) throws SQLException {
        SqlDriver sqlDriver = new SqlDriver();

        for (int i=0; i<arrayList.size(); i++) {
            String Mobile_Number = arrayList.get(i).getMobile_Number();

            String res = null;
            ResultSet rs_0 = null;
            String sql_0 = String.format(GlobalConst.SQL_SELECT_TMOBILE_Mobile_Number, Mobile_Number);
            rs_0 = sqlDriver.executeRead(sql_0);

            if (rs_0.next()) {
                return new SQLResult(false, "ERROR:0");
            }
        }

        int max_Card_Number = 0;
        ResultSet rs_1 = null;
        String sql_1 = GlobalConst.SQL_SELECT_TMOBILE_MAX_NUM;
        rs_1 = sqlDriver.executeRead(sql_1);

        while (rs_1.next()) {
            max_Card_Number = rs_1.getInt("num");
        }

        for (int i=0; i< arrayList.size(); i++) {
            String Mobile_Number = arrayList.get(i).getMobile_Number();
            String Mobile_Type = arrayList.get(i).getMobile_Type();

            String sql_2 = String.format(GlobalConst.SQL_INSERT_TMOBILE, Mobile_Number, Mobile_Type, String.valueOf(max_Card_Number+1), "Y");
            sqlDriver.executeWrite(sql_2);
        }

        return new SQLResult(true);
    }
}
