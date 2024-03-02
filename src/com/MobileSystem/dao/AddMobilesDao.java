package com.MobileSystem.dao;

import com.MobileSystem.bean.TMobile;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddMobilesDao {
    SQLResult addMobiles(ArrayList<TMobile> arrayList) throws SQLException;
}
