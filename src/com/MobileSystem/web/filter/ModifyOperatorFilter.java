package com.MobileSystem.web.filter;

import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Objects;

@WebFilter(servletNames = {"ModifyOperatorServlet"})
public class ModifyOperatorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String T1 = servletRequest.getParameter("T1");
        String T2 = servletRequest.getParameter("T2");
        String T3 = servletRequest.getParameter("T3");
        String T4 = servletRequest.getParameter("T4");

        for (int i = 0; i < GlobalConst.INVALID_CHAR.size(); i++) {
            if (T2.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "姓名不能有空格");
                servletRequest.setAttribute("status", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            if (T3.contains(GlobalConst.INVALID_CHAR.get(i))) {
                servletRequest.setAttribute("message", "密码不能有空格");
                servletRequest.setAttribute("status", false);
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        if (Objects.equals(T2, "")) {
            servletRequest.setAttribute("message", "姓名不能为空");
            servletRequest.setAttribute("status", false);
        }
        else if (Objects.equals(T3, "")) {
            servletRequest.setAttribute("message", "密码不能为空");
            servletRequest.setAttribute("status", false);
        }

        else if (T2.length() > GlobalConst.COL_TO_MAX_LEN.get("TOperator").get("Operator_Name")) {
            servletRequest.setAttribute("message", "姓名长度不能超过"+String.valueOf(GlobalConst.COL_TO_MAX_LEN.get("TOperator").get("Operator_Name")));
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        else if (T3.length() > GlobalConst.COL_TO_MAX_LEN.get("TOperator").get("Operator_Pwd")) {
            servletRequest.setAttribute("message", "密码长度不能超过"+String.valueOf(GlobalConst.COL_TO_MAX_LEN.get("TOperator").get("Operator_Pwd")));
            servletRequest.setAttribute("status", false);
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        else if (!Objects.equals(T3, T4)) {
            servletRequest.setAttribute("message", "两次密码输入不一致");
            servletRequest.setAttribute("status", false);
        }

        SQLResult sqlResult = GlobalConst.validateHigh(T3, T1);
        if (sqlResult.getStatus()) {
            servletRequest.setAttribute("message", "");
            servletRequest.setAttribute("status", true);
        }
        else if (Objects.equals(sqlResult.getMessage(), "ERROR:A")) {
            servletRequest.setAttribute("message", "密码不能和登录ID完全相同");
            servletRequest.setAttribute("status", false);
        }
        else if (Objects.equals(sqlResult.getMessage(), "ERROR:B")) {
            servletRequest.setAttribute("message", "密码长度不能小于8");
            servletRequest.setAttribute("status", false);
        }
        else if (Objects.equals(sqlResult.getMessage(), "ERROR:C")) {
            servletRequest.setAttribute("message", "密码需要包含至少一位数字");
            servletRequest.setAttribute("status", false);
        }
        else if (Objects.equals(sqlResult.getMessage(), "ERROR:D")) {
            servletRequest.setAttribute("message", "密码需要包含至少一位大写字母");
            servletRequest.setAttribute("status", false);
        }
        else if (Objects.equals(sqlResult.getMessage(), "ERROR:E")) {
            servletRequest.setAttribute("message", "密码需要包含至少一位小写字母");
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
