package com.MobileSystem.web.servlet;

import com.MobileSystem.bean.TOperator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/choose")
public class ChooseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 指派地址到各个导航栏的具体功能 */
        String directTo = req.getParameter("directTo");

        if (Objects.equals(directTo, "addOperator")) {
            req.setAttribute("status", "新增操作员");
            req.setAttribute("toShow", "newOperator.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
        else if (Objects.equals(directTo, "displayOperators")) {
            req.setAttribute("status", "显示所有操作员");
            req.getRequestDispatcher("displayOperators").forward(req, resp);
        }
        else if (Objects.equals(directTo, "modOperator")) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");

            req.setAttribute("id", id);
            req.setAttribute("name", name);
            req.setAttribute("status", "修改操作员");
            req.setAttribute("toShow", "modOperator.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
        else if (Objects.equals(directTo, "addMobiles")) {
            req.setAttribute("status", "资源管理");
            req.setAttribute("toShow", "resource.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
        else if (Objects.equals(directTo, "displayMobiles")) {
            req.setAttribute("status", "显示所有电话号码");
            req.getRequestDispatcher("displayMobiles").forward(req, resp);
        }
        else if (Objects.equals(directTo, "updateChargeWithChargeRule")) {
            req.setAttribute("status", "配置业务费用");
            req.setAttribute("toShow", "charge.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
        else if (Objects.equals(directTo, "addCustomer")) {
            req.setAttribute("status", "新增客户>第一步");
            req.setAttribute("toShow", "newCustomer.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
    }
}
