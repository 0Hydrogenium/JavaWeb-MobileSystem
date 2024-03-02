package com.MobileSystem.dao;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddOperatorDaoImpl implements AddOperatorDao {

    @Override
    public SQLResult addOperator(TOperator tOperator) throws SQLException {
        String Operator_ID = tOperator.getOperator_ID();
        String Operator_Name = tOperator.getOperator_Name();
        String Operator_Pwd = tOperator.getOperator_Pwd();
        String Is_Admin = tOperator.getIs_Admin();

        SqlDriver sqlDriver = new SqlDriver();
        ResultSet rs;
        String sql_0 = String.format(GlobalConst.SQL_SELECT_TOPERATOR_Operator_ID, Operator_ID);
        rs = sqlDriver.executeRead(sql_0);

        if (rs.next()) {
            return new SQLResult(false, "ERROR:0");
        }
        else {
            String sql_1 = String.format(GlobalConst.SQL_INSERT_TOPERATOR, Operator_ID, Operator_Name, Operator_Pwd, Is_Admin);
            sqlDriver.executeWrite(sql_1);
        }

        return new SQLResult(true);
    }
}
