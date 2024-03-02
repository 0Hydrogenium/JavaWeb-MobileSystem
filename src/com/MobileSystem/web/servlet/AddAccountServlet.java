package com.MobileSystem.web.servlet;

import com.MobileSystem.bean.TAccount;
import com.MobileSystem.bean.TCustomer;
import com.MobileSystem.service.AddAccountService;
import com.MobileSystem.service.AddAccountServiceImpl;
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

@WebServlet(name = "AddAccountServlet", value = "/addAccount")
public class AddAccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 新增账户 */
        int Account_ID = Integer.parseInt(req.getParameter("Account_ID"));

        Boolean status = (Boolean)req.getAttribute("status");
        String message = (String)req.getAttribute("message");
        if (!status) {
            req.setAttribute("tip", message);
            req.setAttribute("status", "新增账户");
            req.setAttribute("Account_ID", Account_ID);
            req.setAttribute("toShow", "newAccount.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
            return;
        }

        String Contact_Person = req.getParameter("T2");
        String Contact_Address = req.getParameter("T3");
        float Account_Balance = Float.parseFloat(req.getParameter("T4"));

        TAccount tAccount = new TAccount(Account_ID, Contact_Person, Contact_Address, Account_Balance);
        AddAccountService as = new AddAccountServiceImpl();
        SQLResult sqlResult;
        try {
            sqlResult= as.addAccount(tAccount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (sqlResult.getStatus()) {
            req.setAttribute("tip", "提交成功");
            req.setAttribute("status", "登录成功");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else {
            req.setAttribute("tip", "提交失败");
            req.setAttribute("status", "新增账户");
            req.setAttribute("Account_ID", Account_ID);
            req.setAttribute("toShow", "newAccount.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
    }
}
