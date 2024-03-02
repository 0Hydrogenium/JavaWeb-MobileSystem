package com.MobileSystem.dao;

import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteOperatorDaoImpl implements DeleteOperatorDao {
    @Override
    public SQLResult delOperator(String id) throws SQLException {
        SqlDriver sqlDriver = new SqlDriver();

//        ResultSet rs;
//        String sql = String.format(GlobalConst.SQL_SELECT_TOPERATOR_Operator_ID, id);
//        rs = sqlDriver.executeRead(sql);

//        if (rs.next()) {
//            return new SQLResult(false, "ERROR:0");
//        }

        String sql_1 = String.format(GlobalConst.SQL_DELETE_TOPERATOR, id);
        sqlDriver.executeWrite(sql_1);

        return new SQLResult(true);
    }
}
