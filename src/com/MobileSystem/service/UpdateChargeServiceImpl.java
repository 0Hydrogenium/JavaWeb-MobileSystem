package com.MobileSystem.service;

import com.MobileSystem.bean.TCharge;
import com.MobileSystem.dao.UpdateChargeDao;
import com.MobileSystem.dao.UpdateChargeDaoImpl;
import com.MobileSystem.util.SQLResult;

public class UpdateChargeServiceImpl implements UpdateChargeService {
    UpdateChargeDao ud = new UpdateChargeDaoImpl();
    @Override
    public SQLResult updateCharge(TCharge tCharge) {
        return ud.updateCharge(tCharge);
    }
}
