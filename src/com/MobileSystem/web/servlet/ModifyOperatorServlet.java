package com.MobileSystem.web.servlet;

import com.MobileSystem.bean.TOperator;
import com.MobileSystem.service.ModifyOperatorService;
import com.MobileSystem.service.ModifyOperatorServiceImpl;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "ModifyOperatorServlet", value = "/modifyOperator")
public class ModifyOperatorServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 修改操作员 */
        String T1 = req.getParameter("T1");
        String T2 = req.getParameter("T2");
        if (Objects.equals(T1, null)) {
            T1 = "";
        }
        else if (Objects.equals(T2, null)) {
            T2 = "";
        }

        Boolean status = (Boolean)req.getAttribute("status");
        String message = (String)req.getAttribute("message");
        if (!status) {
            req.setAttribute("tip", message);
            req.getRequestDispatcher(String.format("choose?directTo=modOperator&id=%s&name=%s", T1, T2)).forward(req, resp);
            return;
        }

        String T3 = req.getParameter("T3");
        String T4 = req.getParameter("T4");
        String R1 = req.getParameter("R1");

        String R2 = GlobalConst.TWO_TYPES_RADIO_MAPPING.get(R1);

        String hashCode = GlobalConst.hashFunc(T3, GlobalConst.COL_TO_MAX_LEN.get("TOperator").get("Operator_Pwd"));

        TOperator tOperator = new TOperator(T1, T2, hashCode, R2);
        ModifyOperatorService ms = new ModifyOperatorServiceImpl();
        SQLResult sqlResult = ms.modOperator(tOperator);

        if (sqlResult.getStatus()) {
            req.setAttribute("tip", "提交成功");
            req.getRequestDispatcher(String.format("choose?directTo=modOperator&id=%s&name=%s", T1, T2)).forward(req, resp);
        }
        else {
            req.setAttribute("tip", "提交失败");
            req.getRequestDispatcher(String.format("choose?directTo=modOperator&id=%s&name=%s", T1, T2)).forward(req, resp);
        }
    }
}
