package com.MobileSystem.web.filter;

import com.MobileSystem.util.GlobalConst;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Objects;

@WebFilter(servletNames = {"ModifyAccountServlet"})
public class ModifyAccountFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String Account_ID = servletRequest.getParameter("Account_ID");

        for (int i = 0; i < GlobalConst.INVALID_CHAR.size(); i++) {
            if (Account_ID.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "�ͻ�ID�����пո�");
                servletRequest.setAttribute("status_1", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        if (Objects.equals(Account_ID, "")) {
            servletRequest.setAttribute("message", "�ͻ�ID����Ϊ��");
            servletRequest.setAttribute("status_1", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        else if (Account_ID.length() > GlobalConst.COL_TO_MAX_LEN.get("TAccount").get("Account_ID")) {
            servletRequest.setAttribute("message", "�ͻ�ID���Ȳ��ܳ���"+String.valueOf(GlobalConst.COL_TO_MAX_LEN.get("TAccount").get("Account_ID")));
            servletRequest.setAttribute("status_1", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        if (!GlobalConst.isNumeric(Account_ID)) {
            servletRequest.setAttribute("message", "�ͻ�ID�������������");
            servletRequest.setAttribute("status_1", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        else {
            servletRequest.setAttribute("message", "");
            servletRequest.setAttribute("status_1", true);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
