package com.MobileSystem.web.filter;

import com.MobileSystem.util.GlobalConst;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Objects;

@WebFilter(servletNames = {"AddMobilesServlet"})
public class AddMobilesFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String T1 = servletRequest.getParameter("T1");
        String T2 = servletRequest.getParameter("T2");

        for (int i = 0; i < GlobalConst.INVALID_CHAR.size(); i++) {
            if (T1.contains(GlobalConst.INVALID_CHAR.get(i)) || T2.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "电话号码不能有空格");
                servletRequest.setAttribute("status", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        if (Objects.equals(T1, "") || Objects.equals(T2, "")) {
            servletRequest.setAttribute("message", "电话号码不能为空");
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        else if (T1.length() > GlobalConst.COL_TO_MAX_LEN.get("TMobile").get("Mobile_Number") ||
                T2.length() > GlobalConst.COL_TO_MAX_LEN.get("TMobile").get("Mobile_Number")) {
            servletRequest.setAttribute("message", "电话号码长度不能超过"+String.valueOf(GlobalConst.COL_TO_MAX_LEN.get("TMobile").get("Mobile_Number")));
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (!(GlobalConst.isNumeric(T1) && GlobalConst.isNumeric(T2))) {
            servletRequest.setAttribute("message", "电话号码必须由数字组成");
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
