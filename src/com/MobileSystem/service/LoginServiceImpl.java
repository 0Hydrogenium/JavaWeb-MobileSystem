package com.MobileSystem.service;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.dao.LoginDao;
import com.MobileSystem.dao.LoginDaoImpl;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {
    LoginDao ld = new LoginDaoImpl();

    @Override
    public SQLResult getTOperator(TOperator tOperator) throws SQLException {
        return ld.getTOperator(tOperator);
    }
}
