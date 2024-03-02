package com.MobileSystem.web.servlet;

import com.MobileSystem.bean.TCustomer;
import com.MobileSystem.bean.TOperator;
import com.MobileSystem.service.GetCustomerService;
import com.MobileSystem.service.GetCustomerServiceImpl;
import com.MobileSystem.util.SQLResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "GetCustomerServlet", value = "/getCustomer")
public class GetCustomerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 新增客户>第一步 */
        Boolean status = (Boolean)req.getAttribute("status");
        String message = (String)req.getAttribute("message");
        if (!status) {
            req.setAttribute("tip", message);
            req.getRequestDispatcher("choose?directTo=addCustomer").forward(req, resp);
            return;
        }

        String D1 = req.getParameter("D1");
        String T2 = req.getParameter("T2");

        TCustomer tCustomer_0 = new TCustomer(D1, T2);
        GetCustomerService gs = new GetCustomerServiceImpl();
        TCustomer tCustomer_1;
        SQLResult sqlResult;
        try {
            sqlResult = gs.getCustomer(tCustomer_0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (!sqlResult.getStatus()) {
            req.setAttribute("status", "新增客户>第二步");
            req.setAttribute("tCustomer", tCustomer_0);
            req.setAttribute("toShow", "newCustomer1.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
        else {
            tCustomer_1 = (TCustomer)sqlResult.getTarget();

            req.setAttribute("status", "查看客户信息");
            req.setAttribute("tCustomer", tCustomer_1);
            req.setAttribute("toShow", "newCustomer2.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
    }
}
