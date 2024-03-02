package com.MobileSystem.service;

import com.MobileSystem.dao.DeleteOperatorDao;
import com.MobileSystem.dao.DeleteOperatorDaoImpl;
import com.MobileSystem.util.SQLResult;

import java.sql.SQLException;

public class DeleteOperatorServiceImpl implements DeleteOperatorService {
    DeleteOperatorDao dd = new DeleteOperatorDaoImpl();
    @Override
    public SQLResult delOperator(String id) throws SQLException {
        return dd.delOperator(id);
    }
}
