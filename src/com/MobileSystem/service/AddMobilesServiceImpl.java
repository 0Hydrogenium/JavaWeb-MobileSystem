package com.MobileSystem.service;

import com.MobileSystem.bean.TMobile;
import com.MobileSystem.bean.TOperator;
import com.MobileSystem.dao.AddMobilesDao;
import com.MobileSystem.dao.AddMobilesDaoImpl;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddMobilesServiceImpl implements AddMobilesService {
    AddMobilesDao ad = new AddMobilesDaoImpl();

    @Override
    public SQLResult addMobiles(ArrayList<TMobile> arrayList) throws SQLException {
        return ad.addMobiles(arrayList);
    }
}
