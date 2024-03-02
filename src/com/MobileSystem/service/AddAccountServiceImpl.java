package com.MobileSystem.service;

import com.MobileSystem.bean.TAccount;
import com.MobileSystem.dao.AddAccountDao;
import com.MobileSystem.dao.AddAccountDaoImpl;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public class AddAccountServiceImpl implements AddAccountService {
    AddAccountDao ad = new AddAccountDaoImpl();
    @Override
    public SQLResult addAccount(TAccount tAccount) throws SQLException {
        return ad.addAccount(tAccount);
    }
}
