package com.MobileSystem.web.filter;

import com.MobileSystem.util.GlobalConst;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

@WebFilter(servletNames = {"AddCustomerServlet"})
public class AddCustomerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String Customer_Name = servletRequest.getParameter("T1");
        String Customer_Birthday = servletRequest.getParameter("T3");
        String Customer_Address = servletRequest.getParameter("T4");

        for (int i = 0; i < GlobalConst.INVALID_CHAR.size(); i++) {
            if (Customer_Name.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "���������пո�");
                servletRequest.setAttribute("status", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            if (Customer_Birthday.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "���ղ����пո�");
                servletRequest.setAttribute("status", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            if (Customer_Address.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "��ϵ��ַ�����пո�");
                servletRequest.setAttribute("status", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        if (Objects.equals(Customer_Name, "")) {
            servletRequest.setAttribute("message", "��������Ϊ��");
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        else if (Objects.equals(Customer_Birthday, "")) {
            servletRequest.setAttribute("message", "���ղ���Ϊ��");
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        else if (Objects.equals(Customer_Address, "")) {
            servletRequest.setAttribute("message", "��ϵ��ַ����Ϊ��");
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        else if (Customer_Name.length() > GlobalConst.COL_TO_MAX_LEN.get("TCustomer").get("Customer_Name")) {
            servletRequest.setAttribute("message", "�������Ȳ��ܳ���"+String.valueOf(GlobalConst.COL_TO_MAX_LEN.get("TCustomer").get("Customer_Name")));
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        else if (Customer_Address.length() > GlobalConst.COL_TO_MAX_LEN.get("TCustomer").get("Customer_Address")) {
            servletRequest.setAttribute("message", "��ϵ��ַ���Ȳ��ܳ���"+String.valueOf(GlobalConst.COL_TO_MAX_LEN.get("TCustomer").get("Customer_Address")));
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (!GlobalConst.isDate(Customer_Birthday)) {
            servletRequest.setAttribute("message", "���ո�ʽ����");
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        else {
            servletRequest.setAttribute("message", "");
            servletRequest.setAttribute("status", true);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
