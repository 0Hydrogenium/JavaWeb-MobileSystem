package com.MobileSystem.web.filter;

import com.MobileSystem.util.GlobalConst;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Objects;

@WebFilter(servletNames = {"LoginServlet"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String operator_id = servletRequest.getParameter("operator_id");
        String passwords = servletRequest.getParameter("passwords");

        for (int i=0; i < GlobalConst.INVALID_CHAR.size(); i++) {
            if (operator_id.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "用户名不能有空格");
                servletRequest.setAttribute("status", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            if (passwords.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "密码不能有空格");
                servletRequest.setAttribute("status", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        if (Objects.equals(operator_id, "")) {
            servletRequest.setAttribute("message", "用户名不能为空");
            servletRequest.setAttribute("status", false);
        }
        else if (Objects.equals(passwords, "")) {
            servletRequest.setAttribute("message", "密码不能为空");
            servletRequest.setAttribute("status", false);
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
