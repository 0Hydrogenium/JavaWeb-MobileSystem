package com.MobileSystem.dao;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface LoginDao {
    SQLResult getTOperator(TOperator tOperator) throws SQLException;
}
