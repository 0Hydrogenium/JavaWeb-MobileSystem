package com.MobileSystem.web.servlet;

import com.MobileSystem.bean.TAccount;
import com.MobileSystem.service.AddAccountService;
import com.MobileSystem.service.AddAccountServiceImpl;
import com.MobileSystem.service.ModifyAccountService;
import com.MobileSystem.service.ModifyAccountServiceImpl;
import com.MobileSystem.util.GlobalConst;
import com.MobileSystem.util.SQLResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "ModifyAccountServlet", value = "/modifyAccount")
public class ModifyAccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 修改账户 */
        String Customer_ID = req.getParameter("Customer_ID");
        String Account_ID = req.getParameter("Account_ID");

        Boolean status;
        String message;

        if (Objects.equals(Account_ID, "")) {
            message = "客户ID不能为空";
            status = false;
        }

        else if (Account_ID.length() > GlobalConst.COL_TO_MAX_LEN.get("TAccount").get("Account_ID")) {
            message = "客户ID长度不能超过"+String.valueOf(GlobalConst.COL_TO_MAX_LEN.get("TAccount").get("Account_ID"));
            status = false;
        }

        else if (!GlobalConst.isNumeric(Account_ID)) {
            message = "客户ID必须由数字组成";
            status = false;
        }

        else {
            message = "";
            status = true;
        }

        for (int i = 0; i < GlobalConst.INVALID_CHAR.size(); i++) {
            if (Account_ID.contains(GlobalConst.INVALID_CHAR.get(i))) {
                message = "客户ID不能有空格";
                status = false;
                break;
            }
        }

        if (!status) {
            req.setAttribute("tip", message);
            req.setAttribute("status", "新增用户");
            req.setAttribute("Customer_ID", Customer_ID);
            req.setAttribute("toShow", "newUser.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
            return;
        }

        TAccount tAccount = new TAccount(Integer.parseInt(Account_ID));
        ModifyAccountService ms = new ModifyAccountServiceImpl();
        SQLResult sqlResult;
        try {
            sqlResult = ms.modifyAccount(tAccount);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (sqlResult.getStatus()) {
            TAccount tAccount_1 = ((TAccount)sqlResult.getTarget());

            req.setAttribute("Account_ID", String.valueOf(tAccount_1.getAccount_ID()));
            req.setAttribute("Contact_Person", tAccount_1.getContact_Person());
            req.setAttribute("Contact_Address", tAccount_1.getContact_Address());
            req.setAttribute("Account_Balance", tAccount_1.getAccount_Balance());
            req.setAttribute("toShow", "oldAccount.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        } else {
            req.setAttribute("tip", "提交失败");
            req.setAttribute("status", "合账");
            req.setAttribute("Account_ID", Integer.parseInt(Account_ID));
            req.setAttribute("toShow", "oldAccount.jsp");
            req.getRequestDispatcher("main.jsp").forward(req, resp);
        }
    }
}



