package com.MobileSystem.service;

import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface DeleteOperatorService {
    SQLResult delOperator(String id) throws SQLException;
}
