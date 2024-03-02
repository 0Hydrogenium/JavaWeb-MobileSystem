package com.MobileSystem.web.filter;

import com.MobileSystem.util.GlobalConst;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Objects;

@WebFilter(servletNames = {"AddAccountServlet"})
public class AddAccountFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String Contact_Person = servletRequest.getParameter("T2");
        String Contact_Address = servletRequest.getParameter("T3");
        String Account_Balance = servletRequest.getParameter("T4");

        for (int i = 0; i < GlobalConst.INVALID_CHAR.size(); i++) {
            if (Contact_Person.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "姓名不能有空格");
                servletRequest.setAttribute("status", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            if (Contact_Address.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "联系地址不能有空格");
                servletRequest.setAttribute("status", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            if (Account_Balance.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "开户金额不能有空格");
                servletRequest.setAttribute("status", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        if (Objects.equals(Contact_Person, "")) {
            servletRequest.setAttribute("message", "姓名不能为空");
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        else if (Objects.equals(Contact_Address, "")) {
            servletRequest.setAttribute("message", "联系地址不能为空");
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        else if (Objects.equals(Account_Balance, "")) {
            servletRequest.setAttribute("message", "开户金额不能为空");
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        else if (Contact_Person.length() > GlobalConst.COL_TO_MAX_LEN.get("TAccount").get("Contact_Person")) {
            servletRequest.setAttribute("message", "姓名长度不能超过"+String.valueOf(GlobalConst.COL_TO_MAX_LEN.get("TAccount").get("Contact_Person")));
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        else if (Contact_Address.length() > GlobalConst.COL_TO_MAX_LEN.get("TAccount").get("Contact_Address")) {
            servletRequest.setAttribute("message", "联系地址长度不能超过"+String.valueOf(GlobalConst.COL_TO_MAX_LEN.get("TAccount").get("Contact_Address")));
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (!GlobalConst.isDecimal(Account_Balance, "Account_Balance")) {
            servletRequest.setAttribute("message", "开户金额必须为有效小数");
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
