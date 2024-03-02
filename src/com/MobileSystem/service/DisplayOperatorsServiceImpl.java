package com.MobileSystem.service;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.dao.DisplayOperatorsDao;
import com.MobileSystem.dao.DisplayOperatorsDaoImpl;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public class DisplayOperatorsServiceImpl implements DisplayOperatorsService {
    DisplayOperatorsDao mo = new DisplayOperatorsDaoImpl();

    @Override
    public SQLResult getTOperators() throws SQLException {
        return mo.getTOperators();
    }
}
