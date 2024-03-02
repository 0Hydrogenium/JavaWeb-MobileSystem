package com.MobileSystem.service;

import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface DisplayMobilesService {
    SQLResult getMobiles() throws SQLException;
}
