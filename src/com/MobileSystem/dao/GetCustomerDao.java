package com.MobileSystem.dao;

import com.MobileSystem.bean.TCustomer;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public interface GetCustomerDao {
    SQLResult getCustomer(TCustomer tCustomer) throws SQLException;
}
