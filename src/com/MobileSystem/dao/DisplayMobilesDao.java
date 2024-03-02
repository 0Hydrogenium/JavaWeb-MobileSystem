package com.MobileSystem.dao;

import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface DisplayMobilesDao {
    SQLResult getMobiles() throws SQLException;
}
