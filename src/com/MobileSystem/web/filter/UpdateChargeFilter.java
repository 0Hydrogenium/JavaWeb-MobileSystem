package com.MobileSystem.web.filter;

import com.MobileSystem.util.GlobalConst;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Objects;

@WebFilter(servletNames = {"UpdateChargeServlet"})
public class UpdateChargeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String T1 = servletRequest.getParameter("T1");

        for (int i = 0; i < GlobalConst.INVALID_CHAR.size(); i++) {
            if (T1.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "收费金额不能有空格");
                servletRequest.setAttribute("status", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        if (Objects.equals(T1, "")) {
            servletRequest.setAttribute("message", "收费金额不能为空");
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (!GlobalConst.isDecimal(T1, "Charge")) {
            servletRequest.setAttribute("message", "收费金额必须为小数");
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
