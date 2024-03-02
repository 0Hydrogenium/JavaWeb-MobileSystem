package com.MobileSystem.dao;

import com.MobileSystem.bean.TCharge;
import com.MobileSystem.util.SQLResult;

public interface UpdateChargeDao {
    SQLResult updateCharge(TCharge tCharge);
}
