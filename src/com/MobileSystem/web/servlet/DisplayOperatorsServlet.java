package com.MobileSystem.web.servlet;

import com.MobileSystem.bean.TOperator;
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

@WebServlet("/displayOperators")
public class DisplayOperatorsServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 显示所有操作员 */
        DisplayOperatorsService ms = new DisplayOperatorsServiceImpl();
        SQLResult sqlResult;
        ArrayList<TOperator> tOperators;
        try {
            sqlResult = ms.getTOperators();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (sqlResult.getStatus()) {
            tOperators = (ArrayList<TOperator>)sqlResult.getTarget();
            req.setAttribute("operators", tOperators);
            req.setAttribute("toShow", "modifyOperator.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
    }
}
