package com.MobileSystem.service;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.dao.ModifyOperatorDao;
import com.MobileSystem.dao.ModifyOperatorDaoImpl;
import com.MobileSystem.util.SQLResult;

public class ModifyOperatorServiceImpl implements ModifyOperatorService {
    ModifyOperatorDao md = new ModifyOperatorDaoImpl();

    @Override
    public SQLResult modOperator(TOperator tOperator) {
        return md.modOperator(tOperator);
    }
}
