package com.MobileSystem.web.filter;

import com.MobileSystem.util.GlobalConst;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Objects;

@WebFilter(servletNames = {"GetCustomerServlet"})
public class GetCustomerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String T2 = servletRequest.getParameter("T2");

        for (int i = 0; i < GlobalConst.INVALID_CHAR.size(); i++) {
            if (T2.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "֤�����벻���пո�");
                servletRequest.setAttribute("status", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        if (Objects.equals(T2, "")) {
            servletRequest.setAttribute("message", "֤�����벻��Ϊ��");
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        else if (T2.length() > GlobalConst.COL_TO_MAX_LEN.get("TCustomer").get("ID_Number")) {
            servletRequest.setAttribute("message", "֤�����볤�Ȳ��ܳ���"+String.valueOf(GlobalConst.COL_TO_MAX_LEN.get("TCustomer").get("ID_Number")));
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (!GlobalConst.isNumeric(T2)) {
            servletRequest.setAttribute("message", "֤������ֻ�����������");
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
