package com.MobileSystem.dao;

import com.MobileSystem.bean.TCharge_Rule;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

import java.util.ArrayList;

public class UpdateChargeRuleDaoImpl implements UpdateChargeRuleDao {
    @Override
    public SQLResult updateChargeRule(ArrayList<TCharge_Rule> tChargeRules) {
        SqlDriver sqlDriver = new SqlDriver();
        String sql_0 = GlobalConst.SQL_DELETE_TCHARGE_RULE_ALL;
        sqlDriver.executeWrite(sql_0);

        for (int i=0; i<tChargeRules.size(); i++) {
            String Func_ID = tChargeRules.get(i).getFunc_ID();
            String Charge_Code = tChargeRules.get(i).getCharge_Code();
            String Func_Name = tChargeRules.get(i).getFunc_Name();

            String sql_1 = String.format(GlobalConst.SQL_INSERT_TCHARGE_RULE, Func_ID, Charge_Code, Func_Name);
            sqlDriver.executeWrite(sql_1);
        }

        return new SQLResult(true);
    }
}
