package com.MobileSystem.dao;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {

    @Override
    public SQLResult getTOperator(TOperator tOperator) throws SQLException {
        String Operator_ID = tOperator.getOperator_ID();
        String Operator_Pwd = tOperator.getOperator_Pwd();

        SqlDriver sqlDriver = new SqlDriver();

        String sql = String.format(GlobalConst.SQL_SELECT_TOPERATOR_Operator_ID, Operator_ID);
        ResultSet rs = null;
        rs = sqlDriver.executeRead(sql);
        if (!rs.next()) {
            return new SQLResult(false, "ERROR:0");
        }

        String sql_1 = String.format(GlobalConst.SQL_SELECT_TOPERATOR_LOGIN, Operator_ID, Operator_Pwd);
        TOperator tOperator_1 = null;
        ResultSet rs_1;
        rs_1 = sqlDriver.executeRead(sql_1);

        if (rs_1.next()) {
            tOperator_1 = new TOperator();
            tOperator_1.setOperator_ID(rs_1.getString("Operator_ID"));
            tOperator_1.setOperator_Name(rs_1.getString("Operator_Name"));
            tOperator_1.setOperator_Pwd(rs_1.getString("Operator_Pwd"));
            tOperator_1.setIs_Admin(rs_1.getString("Is_Admin"));
        }
        else {
            return new SQLResult(false, "ERROR:1");
        }

        return new SQLResult(true, "", tOperator_1);
    }
}
