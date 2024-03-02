package com.MobileSystem.web.servlet;

import com.MobileSystem.bean.TMobile;
import com.MobileSystem.service.AddMobilesService;
import com.MobileSystem.service.AddMobilesServiceImpl;
import com.MobileSystem.util.SQLResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(name = "AddMobilesServlet", value = "/addMobiles")
public class AddMobilesServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 资源管理 */
        Boolean status = (Boolean)req.getAttribute("status");
        String message = (String)req.getAttribute("message");
        if (!status) {
            req.setAttribute("tip", message);
            req.getRequestDispatcher("choose?directTo=addMobiles").forward(req, resp);
            return;
        }

        String R1 = req.getParameter("R1");
        int T1 = Integer.parseInt(req.getParameter("T1"));
        int T2 = Integer.parseInt(req.getParameter("T2"));

        ArrayList<TMobile> arrayList = new ArrayList<>();
        for (int i=0; i<(T2-T1+1); i++) {
            TMobile tMobile = new TMobile(String.valueOf(T1+i), R1);
            arrayList.add(tMobile);
        }

        AddMobilesService as = new AddMobilesServiceImpl();
        SQLResult sqlResult;
        try {
            sqlResult = as.addMobiles(arrayList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (sqlResult.getStatus()) {
            req.setAttribute("tip", "提交成功");
            req.getRequestDispatcher("choose?directTo=addMobiles").forward(req, resp);
        }
        else if (Objects.equals(sqlResult.getMessage(), "ERROR:0")){
            req.setAttribute("tip", "范围内的部分号码已存在");
            req.getRequestDispatcher("choose?directTo=addMobiles").forward(req, resp);
        }
        else {
            req.setAttribute("tip", "提交失败");
            req.getRequestDispatcher("choose?directTo=addMobiles").forward(req, resp);
        }
    }
}
