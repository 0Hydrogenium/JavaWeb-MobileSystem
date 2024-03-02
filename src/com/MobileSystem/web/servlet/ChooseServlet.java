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
        /* ָ�ɵ�ַ�������������ľ��幦�� */
        String directTo = req.getParameter("directTo");

        if (Objects.equals(directTo, "addOperator")) {
            req.setAttribute("status", "��������Ա");
            req.setAttribute("toShow", "newOperator.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
        else if (Objects.equals(directTo, "displayOperators")) {
            req.setAttribute("status", "��ʾ���в���Ա");
            req.getRequestDispatcher("displayOperators").forward(req, resp);
        }
        else if (Objects.equals(directTo, "modOperator")) {
            String id = req.getParameter("id");
            String name = req.getParameter("name");

            req.setAttribute("id", id);
            req.setAttribute("name", name);
            req.setAttribute("status", "�޸Ĳ���Ա");
            req.setAttribute("toShow", "modOperator.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
        else if (Objects.equals(directTo, "addMobiles")) {
            req.setAttribute("status", "��Դ����");
            req.setAttribute("toShow", "resource.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
        else if (Objects.equals(directTo, "displayMobiles")) {
            req.setAttribute("status", "��ʾ���е绰����");
            req.getRequestDispatcher("displayMobiles").forward(req, resp);
        }
        else if (Objects.equals(directTo, "updateChargeWithChargeRule")) {
            req.setAttribute("status", "����ҵ�����");
            req.setAttribute("toShow", "charge.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
        else if (Objects.equals(directTo, "addCustomer")) {
            req.setAttribute("status", "�����ͻ�>��һ��");
            req.setAttribute("toShow", "newCustomer.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
    }
}
