package com.MobileSystem.web.servlet;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.service.DeleteOperatorService;
import com.MobileSystem.service.DeleteOperatorServiceImpl;
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

@WebServlet("/deleteOperator")
public class DeleteOperatorServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 删除操作员 */
        String T1 = req.getParameter("T1");
        String T2 = req.getParameter("T2");

        HttpSession session = req.getSession();
        String T = ((TOperator)session.getAttribute("tOperator_0")).getOperator_ID();
        if (Objects.equals(T, T1)) {
            req.setAttribute("tip", "无法删除自身账户");
            req.getRequestDispatcher(String.format("choose?directTo=modOperator&id=%s&name=%s", T1, T2)).forward(req, resp);
            return;
        }

        SQLResult sqlResult;
        DeleteOperatorService ds = new DeleteOperatorServiceImpl();
        try {
            sqlResult = ds.delOperator(T1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (sqlResult.getStatus()) {
            req.getRequestDispatcher("choose?directTo=displayOperators").forward(req, resp);
        }
        else {
            req.setAttribute("tip", "操作失败");
        }
    }
}
