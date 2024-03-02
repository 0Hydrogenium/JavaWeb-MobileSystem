package com.MobileSystem.service;

import com.MobileSystem.bean.TAccount;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface AddAccountService {
    SQLResult addAccount(TAccount tAccount) throws SQLException;
}
