package com.MobileSystem.service;

import com.MobileSystem.bean.TUser;
import com.MobileSystem.dao.AddUserDao;
import com.MobileSystem.dao.AddUserDaoImpl;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public class AddUserServiceImpl implements AddUserService {
    AddUserDao ad = new AddUserDaoImpl();
    @Override
    public SQLResult addUser(TUser tUser) throws SQLException {
        return ad.addUser(tUser);
    }
}
