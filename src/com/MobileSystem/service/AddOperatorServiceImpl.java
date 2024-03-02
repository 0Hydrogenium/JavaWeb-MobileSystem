package com.MobileSystem.service;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.dao.AddOperatorDao;
import com.MobileSystem.dao.AddOperatorDaoImpl;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public class AddOperatorServiceImpl implements AddOperatorService {
    AddOperatorDao ad = new AddOperatorDaoImpl();
    @Override
    public SQLResult addOperator(TOperator tOperator) throws SQLException {
        return ad.addOperator(tOperator);
    }
}
