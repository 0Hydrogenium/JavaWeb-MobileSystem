package com.MobileSystem.service;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface AddOperatorService {
    SQLResult addOperator(TOperator tOperator) throws SQLException;
}
