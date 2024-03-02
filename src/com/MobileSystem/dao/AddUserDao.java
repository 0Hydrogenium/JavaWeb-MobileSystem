package com.MobileSystem.dao;

import com.MobileSystem.bean.TUser;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface AddUserDao {
    SQLResult addUser(TUser tUser) throws SQLException;
}
