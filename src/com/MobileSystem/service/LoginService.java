package com.MobileSystem.service;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface LoginService {
    SQLResult getTOperator(TOperator tOperator) throws SQLException;
}
