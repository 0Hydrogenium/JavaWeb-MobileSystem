package com.MobileSystem.web.servlet;

import com.MobileSystem.bean.TCustomer;
import com.MobileSystem.bean.TOperator;
import com.MobileSystem.service.AddCustomerService;
import com.MobileSystem.service.AddCustomerServiceImpl;
import com.MobileSystem.util.SQLResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddCustomerServlet", value = "/addCustomer")
public class AddCustomerServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 新增客户>第二步 */
        String ID_Type = req.getParameter("id");
        String ID_Number = req.getParameter("number");
        TCustomer tCustomer_0 = new TCustomer(ID_Type, ID_Number);

        Boolean status = (Boolean)req.getAttribute("status");
        String message = (String)req.getAttribute("message");
        if (!status) {
            req.setAttribute("tip", message);
            req.setAttribute("status", "新增客户>第二步");
            req.setAttribute("tCustomer", tCustomer_0);
            req.setAttribute("toShow", "newCustomer1.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
            return;
        }

        String Customer_Name = req.getParameter("T1");
        String Customer_Birthday = req.getParameter("T3");
        String Customer_Sex = req.getParameter("R1");
        String Customer_Address = req.getParameter("T4");

        TCustomer tCustomer = new TCustomer(ID_Type, ID_Number, Customer_Name, Customer_Birthday, Customer_Sex, Customer_Address);
        AddCustomerService as = new AddCustomerServiceImpl();
        SQLResult sqlResult;
        try {
            sqlResult = as.addCustomer(tCustomer);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int Customer_ID = ((TCustomer)sqlResult.getTarget()).getCustomer_ID();

        if (sqlResult.getStatus()) {
            req.setAttribute("status", "新增用户");
            req.setAttribute("Customer_ID", Customer_ID);
            req.setAttribute("toShow", "newUser.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else {
            req.setAttribute("tip", "提交失败");
            req.setAttribute("status", "新增客户>第二步");
            req.setAttribute("tCustomer", tCustomer_0);
            req.setAttribute("toShow", "newCustomer1.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
    }
}
