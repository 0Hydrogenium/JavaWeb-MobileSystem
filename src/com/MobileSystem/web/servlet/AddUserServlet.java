package com.MobileSystem.web.servlet;

import com.MobileSystem.bean.TCustomer;
import com.MobileSystem.bean.TUser;
import com.MobileSystem.service.AddCustomerService;
import com.MobileSystem.service.AddCustomerServiceImpl;
import com.MobileSystem.service.AddUserService;
import com.MobileSystem.service.AddUserServiceImpl;
import com.MobileSystem.util.SQLResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "AddUserServlet", value = "/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 新增用户 */

        String Customer_ID = req.getParameter("Customer_ID");

        Boolean status = (Boolean)req.getAttribute("status");
        String message = (String)req.getAttribute("message");
        if (!status) {
            req.setAttribute("tip", message);
            req.setAttribute("status", "新增用户");
            req.setAttribute("Customer_ID", Customer_ID);
            req.setAttribute("toShow", "newUser.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
            return;
        }

        String Account_ID = req.getParameter("T3");
        String Mobile_Number = req.getParameter("T1");
        String Roaming_Status = req.getParameter("R1");
        String Com_Level = req.getParameter("R2");

        TUser tUser = new TUser(Integer.parseInt(Account_ID), Mobile_Number, Integer.parseInt(Customer_ID), Roaming_Status, Com_Level);
        AddUserService as = new AddUserServiceImpl();
        SQLResult sqlResult;
        try {
            sqlResult = as.addUser(tUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (sqlResult.getStatus()) {
            req.setAttribute("status", "合账");
            req.setAttribute("Account_ID", Account_ID);
            req.setAttribute("Customer_ID", Customer_ID);
            req.getRequestDispatcher(String.format("modifyAccount?Account_ID=%s", Account_ID)).forward(req, resp);
        }
        else if (Objects.equals(sqlResult.getMessage(), "ERROR:1")) {
            req.setAttribute("status", "新增账户");
            req.setAttribute("Account_ID", Account_ID);
            req.setAttribute("toShow", "newAccount.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
        else if (Objects.equals(sqlResult.getMessage(), "ERROR:0")) {
            req.setAttribute("tip", "该手机号码不存在");
            req.setAttribute("status", "新增用户");
            req.setAttribute("Customer_ID", Customer_ID);
            req.setAttribute("toShow", "newUser.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("tip", "提交失败");
            req.setAttribute("status", "新增用户");
            req.setAttribute("Customer_ID", Customer_ID);
            req.setAttribute("toShow", "newUser.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }

    }
}
