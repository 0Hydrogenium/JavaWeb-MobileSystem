package com.MobileSystem.dao;

import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface DeleteOperatorDao {
    SQLResult delOperator(String id) throws SQLException;
}
