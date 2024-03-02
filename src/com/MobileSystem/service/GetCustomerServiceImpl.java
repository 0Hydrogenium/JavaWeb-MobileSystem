package com.MobileSystem.service;

import com.MobileSystem.bean.TCustomer;
import com.MobileSystem.dao.GetCustomerDao;
import com.MobileSystem.dao.GetCustomerDaoImpl;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public class GetCustomerServiceImpl implements GetCustomerService {
    GetCustomerDao cd = new GetCustomerDaoImpl();
    @Override
    public SQLResult getCustomer(TCustomer tCustomer) throws SQLException {
        return cd.getCustomer(tCustomer);
    }
}
