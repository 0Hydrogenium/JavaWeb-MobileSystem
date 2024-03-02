package com.MobileSystem.service;

import com.MobileSystem.bean.TCustomer;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface AddCustomerService {
    SQLResult addCustomer(TCustomer tCustomer) throws SQLException;
}
