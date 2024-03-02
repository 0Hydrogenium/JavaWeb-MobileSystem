package com.MobileSystem.web.servlet;

import com.MobileSystem.bean.TCharge_Rule;
import com.MobileSystem.service.UpdateChargeRuleService;
import com.MobileSystem.service.UpdateChargeRuleServiceImpl;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;
import com.MobileSystem.util.SqlDriver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet("/updateChargeRule")
public class UpdateChargeRuleServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 配置业务收费 */
        String D1 = req.getParameter("D1");
        ArrayList<String> arrayList_0 = new ArrayList<>();
        String C1 = req.getParameter("C1");
        String C2 = req.getParameter("C2");
        String C3 = req.getParameter("C3");
        String C4 = req.getParameter("C4");
        String C5 = req.getParameter("C5");

        if (Objects.equals(C1, "ON")) {
            arrayList_0.add("A");
        }
        if (Objects.equals(C2, "ON")) {
            arrayList_0.add("B");
        }
        if (Objects.equals(C3, "ON")) {
            arrayList_0.add("C");
        }
        if (Objects.equals(C4, "ON")) {
            arrayList_0.add("D");
        }
        if (Objects.equals(C5, "ON")) {
            arrayList_0.add("E");
        }

        String name = GlobalConst.Func_ID_TO_Func_Name.get(D1);

        ArrayList<TCharge_Rule> arrayList_1 = new ArrayList<>();
        for (int i=0; i<arrayList_0.size(); i++) {
            TCharge_Rule tChargeRule = new TCharge_Rule(D1, arrayList_0.get(i), name);
            arrayList_1.add(tChargeRule);
        }

        UpdateChargeRuleService us = new UpdateChargeRuleServiceImpl();
        SQLResult sqlResult;
        sqlResult = us.updateChargeRule(arrayList_1);

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
