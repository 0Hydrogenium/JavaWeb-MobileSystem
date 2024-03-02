package com.MobileSystem.service;

import com.MobileSystem.bean.TCharge_Rule;
import com.MobileSystem.dao.UpdateChargeRuleDao;
import com.MobileSystem.dao.UpdateChargeRuleDaoImpl;
import com.MobileSystem.util.SQLResult;

import java.util.ArrayList;

public class UpdateChargeRuleServiceImpl implements UpdateChargeRuleService {
    UpdateChargeRuleDao ud = new UpdateChargeRuleDaoImpl();
    @Override
    public SQLResult updateChargeRule(ArrayList<TCharge_Rule> tChargeRules) {
        return ud.updateChargeRule(tChargeRules);
    }
}
