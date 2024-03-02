<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
  <META http-equiv=Content-Type content="text/html; charset=gb2312">
  <META content="MSHTML 6.00.2600.0" name=GENERATOR>
  <link href="style.css" rel="stylesheet" type="text/css">

  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</HEAD>
<BODY>
<table border="1" width="100%" height="89">
  <tr>
    <td width="25%" align="center" height="16">电话号码</td>
    <td width="25%" align="center" height="16">账号ID</td>
    <td width="25%" align="center" height="16">号码类型</td>
    <td width="25%" align="center" height="16">分组</td>
    <td width="25%" align="center" height="16">是否可用</td>
<%--    <td width="25%" align="center" height="16">修改</td>--%>
  </tr>
  <c:forEach items="${mobiles}" var="mobile">
    <tr>
      <td width="25%" align="center" height="17">${mobile.getMobile_Number()}</td>
      <td width="25%" align="center" height="17">${mobile.getAccount_ID() != 0 ? String.valueOf(mobile.getAccount_ID()) : ''}</td>
      <td width="25%" align="center" height="17">${mobile.getMobile_Type()}</td>
      <td width="25%" align="center" height="17">${mobile.getCard_Number()}</td>
      <td width="25%" align="center" height="17">${mobile.getIs_Available() == "Y" ? '是' : '否'}</td>
<%--      <td width="25%" align="center" height="17"><a href="">&gt;&gt;</a></td>--%>
    </tr>
  </c:forEach>
  <tr>
    <td width="25%" align="center" height="16">&nbsp;</td>
    <td width="25%" align="center" height="16">&nbsp;</td>
    <td width="25%" align="center" height="16">&nbsp;</td>
    <td width="25%" align="center" height="16">&nbsp;</td>
    <td width="25%" align="center" height="16">&nbsp;</td>
<%--    <td width="25%" align="center" height="16">&nbsp;</td>--%>
  </tr>
</table>
</BODY></HTML>
