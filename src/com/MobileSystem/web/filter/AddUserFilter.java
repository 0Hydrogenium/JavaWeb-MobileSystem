package com.MobileSystem.web.filter;

import com.MobileSystem.util.GlobalConst;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Objects;

@WebFilter(servletNames = {"AddUserServlet"})
public class AddUserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String Account_ID = servletRequest.getParameter("T3");
        String Mobile_Number = servletRequest.getParameter("T1");

        for (int i = 0; i < GlobalConst.INVALID_CHAR.size(); i++) {
            if (Account_ID.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "账号不能有空格");
                servletRequest.setAttribute("status", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            if (Mobile_Number.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "手机号码不能有空格");
                servletRequest.setAttribute("status", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        if (Objects.equals(Account_ID, "")) {
            servletRequest.setAttribute("message", "账号不能为空");
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        else if (Objects.equals(Mobile_Number, "")) {
            servletRequest.setAttribute("message", "手机号码不能为空");
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        else if (Account_ID.length() > GlobalConst.COL_TO_MAX_LEN.get("TUser").get("Account_ID")) {
            servletRequest.setAttribute("message", "账号长度不能超过"+String.valueOf(GlobalConst.COL_TO_MAX_LEN.get("TUser").get("Account_ID")));
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        else if (Mobile_Number.length() > GlobalConst.COL_TO_MAX_LEN.get("TUser").get("Mobile_Number")) {
            servletRequest.setAttribute("message", "手机号码长度不能超过"+String.valueOf(GlobalConst.COL_TO_MAX_LEN.get("TUser").get("Mobile_Number")));
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (!GlobalConst.isNumeric(Account_ID)) {
            servletRequest.setAttribute("message", "账号只能由数字组成");
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
