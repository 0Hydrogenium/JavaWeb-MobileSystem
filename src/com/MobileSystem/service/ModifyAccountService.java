package com.MobileSystem.service;

import com.MobileSystem.bean.TAccount;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface ModifyAccountService {
    SQLResult modifyAccount(TAccount tAccount) throws SQLException;
}
