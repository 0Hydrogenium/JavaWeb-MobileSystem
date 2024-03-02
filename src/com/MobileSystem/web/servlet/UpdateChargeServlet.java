package com.MobileSystem.web.servlet;

import com.MobileSystem.bean.TCharge;
import com.MobileSystem.service.UpdateChargeService;
import com.MobileSystem.service.UpdateChargeServiceImpl;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateChargeServlet", value = "/updateCharge")
public class UpdateChargeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 配置收费细项 */
        Boolean status = (Boolean)req.getAttribute("status");
        String message = (String)req.getAttribute("message");
        if (!status) {
            req.setAttribute("tip", message);
            req.getRequestDispatcher("choose?directTo=updateChargeWithChargeRule").forward(req, resp);
            return;
        }

        String D1 = req.getParameter("D1");
        float T1 = Float.parseFloat(req.getParameter("T1"));

        String name = GlobalConst.Charge_Code_TO_Charge_Name.get(D1);

        TCharge tCharge = new TCharge(D1, name, T1);
        UpdateChargeService us = new UpdateChargeServiceImpl();
        SQLResult sqlResult;
        sqlResult = us.updateCharge(tCharge);

        if (sqlResult.getStatus()) {
            req.setAttribute("tip", "提交成功");
            req.getRequestDispatcher("choose?directTo=updateChargeWithChargeRule").forward(req, resp);
        }
        else {
            req.setAttribute("tip", "提交失败");
            req.getRequestDispatcher("choose?directTo=updateChargeWithChargeRule").forward(req, resp);
        }
    }
}
