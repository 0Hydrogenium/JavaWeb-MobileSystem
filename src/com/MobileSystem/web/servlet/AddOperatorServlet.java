package com.MobileSystem.web.servlet;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.service.AddOperatorService;
import com.MobileSystem.service.AddOperatorServiceImpl;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "AddOperatorServlet", value = "/addOperator")
public class AddOperatorServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 新增操作员 */

        Boolean status = (Boolean)req.getAttribute("status");
        String message = (String)req.getAttribute("message");
        if (!status) {
            req.setAttribute("tip", message);
            req.getRequestDispatcher("choose?directTo=addOperator").forward(req, resp);
            return;
        }

        String T1 = req.getParameter("T1");
        String T2 = req.getParameter("T2");
        String T3 = req.getParameter("T3");
        String R1 = req.getParameter("R1");

        String R2 = GlobalConst.TWO_TYPES_RADIO_MAPPING.get(R1);

        // 使用哈希函数对密码进行加密
        String hashCode = GlobalConst.hashFunc(T3, GlobalConst.COL_TO_MAX_LEN.get("TOperator").get("Operator_Pwd"));

        TOperator tOperator = new TOperator(T1, T2, hashCode, R2);
        AddOperatorService as = new AddOperatorServiceImpl();
        SQLResult sqlResult;
        try {
            sqlResult = as.addOperator(tOperator);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (sqlResult.getStatus()) {
            req.setAttribute("tip", "提交成功");
            req.getRequestDispatcher("choose?directTo=addOperator").forward(req, resp);
        }
        else if (Objects.equals(sqlResult.getMessage(), "ERROR:0")) {
            req.setAttribute("tip", "该登录ID的用户已存在");
            req.getRequestDispatcher("choose?directTo=addOperator").forward(req, resp);
        }
        else {
            req.setAttribute("tip", "提交失败");
            req.getRequestDispatcher("choose?directTo=addOperator").forward(req, resp);
        }
    }
}
