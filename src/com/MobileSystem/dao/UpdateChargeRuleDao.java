package com.MobileSystem.dao;

import com.MobileSystem.bean.TCharge_Rule;
import com.MobileSystem.util.SQLResult;

import java.util.ArrayList;

public interface UpdateChargeRuleDao {
    SQLResult updateChargeRule(ArrayList<TCharge_Rule> tChargeRules);
}
