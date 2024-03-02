package com.MobileSystem.dao;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface AddOperatorDao {
    SQLResult addOperator(TOperator tOperator) throws SQLException;
}
