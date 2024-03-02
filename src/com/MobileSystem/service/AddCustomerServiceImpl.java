package com.MobileSystem.service;

import com.MobileSystem.bean.TCustomer;
import com.MobileSystem.dao.AddCustomerDao;
import com.MobileSystem.dao.AddCustomerDaoImpl;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public class AddCustomerServiceImpl implements AddCustomerService {
    AddCustomerDao ad = new AddCustomerDaoImpl();
    @Override
    public SQLResult addCustomer(TCustomer tCustomer) throws SQLException {
        return ad.AddCustomer(tCustomer);
    }
}
