package com.MobileSystem.web.servlet;

import com.MobileSystem.bean.TMobile;
import com.MobileSystem.bean.TOperator;
import com.MobileSystem.service.DisplayMobilesService;
import com.MobileSystem.service.DisplayMobilesServiceImpl;
import com.MobileSystem.service.DisplayOperatorsService;
import com.MobileSystem.service.DisplayOperatorsServiceImpl;
import com.MobileSystem.util.SQLResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/displayMobiles")
public class DisplayMobilesServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 显示所有电话号码 */
        DisplayMobilesService ds = new DisplayMobilesServiceImpl();
        SQLResult sqlResult;
        ArrayList<TMobile> tMobiles;
        try {
            sqlResult = ds.getMobiles();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (sqlResult.getStatus()) {
            tMobiles = (ArrayList<TMobile>)sqlResult.getTarget();
            req.setAttribute("mobiles", tMobiles);
            req.setAttribute("toShow", "displayMobiles.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
    }
}
