package com.MobileSystem.web.servlet;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.service.LoginService;
import com.MobileSystem.service.LoginServiceImpl;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;


@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 登录 */
        Boolean status = (Boolean)req.getAttribute("status");
        String message = (String)req.getAttribute("message");
        if (!status) {
            req.setAttribute("tip", message);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            return;
        }

        String operator_id = req.getParameter("operator_id");
        String passwords = req.getParameter("passwords");

        String hashCode;
        // 测试操作员登录无需哈希函数
        if (!(Objects.equals(operator_id, "h1") || Objects.equals(operator_id, "h2"))) {
            // 使用哈希函数对密码进行加密
            hashCode = GlobalConst.hashFunc(passwords, GlobalConst.COL_TO_MAX_LEN.get("TOperator").get("Operator_Pwd"));
        }
        else {
            hashCode = passwords;
        }

        TOperator tOperator = new TOperator(operator_id, hashCode);
        LoginService ls = new LoginServiceImpl();
        SQLResult sqlResult;
        try {
            sqlResult = ls.getTOperator(tOperator);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (sqlResult.getStatus()) {
            TOperator tOperator_1 = (TOperator)sqlResult.getTarget();
            HttpSession session = req.getSession();
            session.setAttribute("tOperator_0", tOperator_1);

            req.setAttribute("status", "登录成功");
            session.setAttribute("welcomeWords", "当前用户: " + tOperator_1.getOperator_Name());
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
        else if (Objects.equals(sqlResult.getMessage(), "ERROR:0")) {
            req.setAttribute("tip", "用户名不存在");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        else if (Objects.equals(sqlResult.getMessage(), "ERROR:1")) {
            req.setAttribute("tip", "密码错误");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
