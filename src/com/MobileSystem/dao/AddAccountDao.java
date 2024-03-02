package com.MobileSystem.dao;

import com.MobileSystem.bean.TAccount;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface AddAccountDao {
    SQLResult addAccount(TAccount tAccount) throws SQLException;
}
