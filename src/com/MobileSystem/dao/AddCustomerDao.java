package com.MobileSystem.dao;

import com.MobileSystem.bean.TCustomer;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface AddCustomerDao {
    SQLResult AddCustomer(TCustomer tCustomer) throws SQLException;
}
