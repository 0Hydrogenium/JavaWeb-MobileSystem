package com.MobileSystem.service;

import com.MobileSystem.dao.DisplayMobilesDao;
import com.MobileSystem.dao.DisplayMobilesDaoImpl;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public class DisplayMobilesServiceImpl implements DisplayMobilesService {
    DisplayMobilesDao dd = new DisplayMobilesDaoImpl();

    @Override
    public SQLResult getMobiles() throws SQLException {
        return dd.getMobiles();
    }
}
