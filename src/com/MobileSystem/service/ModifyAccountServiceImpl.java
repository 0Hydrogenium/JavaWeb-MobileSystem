package com.MobileSystem.service;

import com.MobileSystem.bean.TAccount;
import com.MobileSystem.dao.ModifyAccountDao;
import com.MobileSystem.dao.ModifyAccountDaoImpl;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public class ModifyAccountServiceImpl implements ModifyAccountService {
    ModifyAccountDao md = new ModifyAccountDaoImpl();

    @Override
    public SQLResult modifyAccount(TAccount tAccount) throws SQLException {
        return md.modifyAccount(tAccount);
    }
}
