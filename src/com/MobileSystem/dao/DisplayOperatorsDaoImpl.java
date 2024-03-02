package com.MobileSystem.dao;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DisplayOperatorsDaoImpl implements DisplayOperatorsDao {
    @Override
    public SQLResult getTOperators() throws SQLException {
        ArrayList<TOperator> arrayList = new ArrayList<>();

        SqlDriver sqlDriver = new SqlDriver();
        String sql = GlobalConst.SQL_SELECT_TOPERATOR_ALL;
        TOperator tOperator;
        ResultSet rs;
        rs = sqlDriver.executeRead(sql);

        while (rs.next()) {
            tOperator = new TOperator();
            tOperator.setOperator_ID(rs.getString("Operator_ID"));
            tOperator.setOperator_Name(rs.getString("Operator_Name"));
            tOperator.setOperator_Pwd(rs.getString("Operator_Pwd"));
            tOperator.setIs_Admin(rs.getString("Is_Admin"));

            arrayList.add(tOperator);
        }

        return new SQLResult(true, "", arrayList);
    }
}
