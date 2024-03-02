package com.MobileSystem.service;

import com.MobileSystem.bean.TUser;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface AddUserService {
    SQLResult addUser(TUser tUser) throws SQLException;
}
