package com.MobileSystem.service;

import com.MobileSystem.bean.TCharge;
import com.MobileSystem.bean.TCharge_Rule;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

import java.util.ArrayList;

public interface UpdateChargeRuleService {
    SQLResult updateChargeRule(ArrayList<TCharge_Rule> tChargeRules);
}
