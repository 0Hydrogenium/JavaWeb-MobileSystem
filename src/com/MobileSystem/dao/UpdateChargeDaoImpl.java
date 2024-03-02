package com.MobileSystem.dao;

import com.MobileSystem.bean.TCharge;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

public class UpdateChargeDaoImpl implements UpdateChargeDao {

    @Override
    public SQLResult updateCharge(TCharge tCharge) {
        String Charge_Code = tCharge.getCharge_Code();
        String Charge_Name = tCharge.getCharge_Name();
        float Charge = tCharge.getCharge();

        SqlDriver sqlDriver = new SqlDriver();
        String sql = String.format(GlobalConst.SQL_UPDATE_TCHARGE, Charge_Name, Charge, Charge_Code);
        sqlDriver.executeWrite(sql);

        return new SQLResult(true);
    }
}
