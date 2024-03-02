<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</HEAD>
<BODY bgColor=#ffffff leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
<CENTER>
<TABLE cellSpacing=0 cellPadding=0 width=749 border=0>
  <TBODY>
  <TR>
    <TD width=173><A href="http://www.chinamobile.com/index.asp"><IMG 
      height=74 src="images/logo.gif" width=173 border=0></A></TD>
    <TD vAlign=top align=right>
      <TABLE width="100%" border=0 cellPadding=0 cellSpacing=0>
        <TBODY>
        <TR bgColor=#2650a6>
          <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD height="12"><img src="images/spacer.gif" width="1" height="1"></TD>
        </TR>
        <TR bgColor=#FFFFFF>
          <TD><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD><img src="images/spacer.gif" width="1" height="1"></TD>
          <TD><img src="images/spacer.gif" width="1" height="1"></TD>
        </TR>
        <TR>
          <TD><img src="images/pic01.gif" width="115" height="55"></TD>
          <TD><img src="images/pic04.gif" width="115" height="55"></TD>
          <TD><img src="images/pic03.gif" width="115" height="55"></TD>
          <TD><img src="images/pic02.gif" width="115" height="55"></TD>
          <TD><img src="images/pic05.gif" width="115" height="55"></TD>
        </TR></TBODY></TABLE></TD></TR>
  <TR>
    <TD height="12" colSpan=2 align=right bgColor=#d4dced>
     

      <img src="images/spacer.gif" width="1" height="1">
      <TABLE cellSpacing=0 cellPadding=0 border=0>
        <TBODY>
        <TR>
          </TR></TBODY></TABLE>
 
    </TD></TR>
  <TR>
  <TD colSpan=2><IMG height=2 src="images\blank(1).gif" width=1></TD></TR></TBODY></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width=749 border=0>
  <TBODY>
  <TR vAlign=top>
    <TD width=173 bgColor=#c9d3e9 rowSpan=2>
      <TABLE cellSpacing=0 cellPadding=0 width=173 border=0>
        <TBODY>
        <c:if test="${sessionScope.tOperator_0.getIs_Admin() == 'Y'}">
          <TR>
            <TD width=11 height="29" bgColor=#2650a6><IMG height=1
              src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
            <TD width=165 height="29" bgColor=#7691c7>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
              class=nav
              href="choose?directTo=addOperator">新增操作员</A>
            </TD>
          </TR>
        </c:if>
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1
            src="images/blank.gif" width=1 border=0></TD></TR>
        <c:if test="${sessionScope.tOperator_0.getIs_Admin() == 'Y'}">
          <TR>
            <TD width=11 bgColor=#2650a6><IMG height=1
              src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
            <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
              class=nav
              href="choose?directTo=displayOperators">修改操作员</A></TD>
          </TR>
        </c:if>
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1 
            src="images/blank.gif" width=1 border=0></TD>
        </TR>
        <TR>
        
        </TR>
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1 
            src="images/blank.gif" width=1 border=0></TD></TR>
        <c:if test="${sessionScope.tOperator_0.getIs_Admin() == 'Y'}">
          <TR>
            <TD width=11 bgColor=#2650a6><IMG height=1
              src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
            <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
              class=nav href="choose?directTo=addMobiles">资源管理</A></TD>
          </TR>
        </c:if>
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1
                                             src="images/blank.gif" width=1 border=0></TD></TR>

        <c:if test="${sessionScope.tOperator_0.getIs_Admin() == 'Y'}">
          <TR>
            <TD width=11 bgColor=#2650a6><IMG height=1
                                              src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
            <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
                    class=nav
                    href="choose?directTo=displayMobiles">查看号码</A></TD>
          </TR>
        </c:if>

        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1
            src="images/blank.gif" width=1 border=0></TD></TR>
        <c:if test="${sessionScope.tOperator_0.getIs_Admin() == 'Y'}">
          <TR>
            <TD width=11 bgColor=#2650a6><IMG height=1
              src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
            <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A
              class=nav href="choose?directTo=updateChargeWithChargeRule">配置业务费用</A></TD>
          </TR>
        </c:if>
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1 
            src="images/blank.gif" width=1 border=0></TD></TR>
        <TR>
          <!--TD width=11 bgColor=#2650a6><IMG height=1 
            src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
          <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A 
            class=nav 
            href="#"></A></TD-->
        </TR>
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1 
            src="images/blank.gif" width=1 border=0></TD></TR>
        <TR>
          <TD width=11 bgColor=#2650a6><IMG height=1 
            src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
          <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A 
            class=nav 
            href="choose?directTo=addCustomer">开户</A></TD>
        </TR>
        <!--TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1 
            src="images/blank.gif" width=1 border=0></TD></TR>
        <TR>
          <TD width=11 bgColor=#2650a6><IMG height=1 
            src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
          <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A 
            class=nav 
            href="newUser.htm">录入用户信息</A></TD>
        </TR>
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1 
            src="images/blank.gif" width=1 border=0></TD></TR>
        <TR>
          <TD width=11 bgColor=#2650a6><IMG height=1 
            src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
          <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A 
            class=nav 
            href="newAccount.htm">录入账户信息</A></TD>
        </TR-->
        
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1 
            src="images/blank.gif" width=1 border=0></TD>
        </TR>
        <TR>
        
        </TR>
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1 
            src="images/blank.gif" width=1 border=0></TD></TR>
        <TR>
          <TD width=11 bgColor=#2650a6><IMG height=1 
            src="images/blank.gif" width=1 border=0><img src="images/Arrow1.gif" width="23" height="23"></TD>
          <TD width=165 height="29" bgColor=#7691c7>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<A 
            class=nav 
            href="logout">退出</A></TD>
        </TR>
        <TR>
          <TD bgColor=#ffffff colSpan=2><IMG height=1 
            src="images/blank.gif" width=1 border=0></TD></TR>

        <TR align=middle>
          <TD colSpan=2 height=160>&nbsp;</TD></TR>
        <TR>
          <TD colSpan=2><IMG height=1 src="images/blank.gif" 
        width=1></TD></TR></TBODY></TABLE></TD>
    <TD width=2 rowSpan=3><IMG height=1 src="images\blank(1).gif" width=2></TD>
    <TD width="2">
      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TBODY>
        <TR>
          <TD height=25>&nbsp;您现在的位置：${status}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${sessionScope.welcomeWords}</TD>
        </TR>
        <TR>
          <TD bgColor=#2650a6><IMG height=1 src="images\blank(1).gif" 
            width=1></TD></TR>
        <TR>
          <TD><IMG height=2 src="images\blank(1).gif" width=574></TD></TR></TBODY></TABLE></TD></TR>
  <TR vAlign=top>
    <TD height="600" bgColor=#f1f3f9>
      <jsp:include page="${toShow == null ? 'blank.jsp' : toShow}"></jsp:include>
    </TD>
    </TR>
  </TBODY></TABLE>
<BR></CENTER></BODY></HTML>
