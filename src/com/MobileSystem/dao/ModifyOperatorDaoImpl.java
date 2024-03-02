package com.MobileSystem.dao;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

public class ModifyOperatorDaoImpl implements ModifyOperatorDao {

    @Override
    public SQLResult modOperator(TOperator tOperator) {
        String Operator_ID = tOperator.getOperator_ID();
        String Operator_Name = tOperator.getOperator_Name();
        String Operator_Pwd = tOperator.getOperator_Pwd();
        String Is_Admin = tOperator.getIs_Admin();

        SqlDriver sqlDriver = new SqlDriver();
        String sql = String.format(GlobalConst.SQL_UPDATE_TOPERATOR, Operator_Name, Operator_Pwd, Is_Admin, Operator_ID);
        sqlDriver.executeWrite(sql);

        return new SQLResult(true);
    }
}
