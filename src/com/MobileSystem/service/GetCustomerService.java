package com.MobileSystem.service;

import com.MobileSystem.bean.TCustomer;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface GetCustomerService {
    SQLResult getCustomer(TCustomer tCustomer) throws SQLException;
}
