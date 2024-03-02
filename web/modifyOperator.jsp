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
        <td width="25%" align="center" height="16">登录ID</td>
        <td width="25%" align="center" height="16">姓名</td>
        <td width="25%" align="center" height="16">是否管理员</td>
        <td width="25%" align="center" height="16">修改</td>
      </tr>
      <c:forEach items="${operators}" var="operator">
        <tr>
          <td width="25%" align="center" height="17">${operator.getOperator_ID()}</td>
          <td width="25%" align="center" height="17">${operator.getOperator_Name()}</td>
          <td width="25%" align="center" height="17">${operator.getIs_Admin() == "Y" ? '是' : '否'}</td>
          <td width="25%" align="center" height="17"><a href="choose?directTo=modOperator&id=${operator.getOperator_ID()}&name=${operator.getOperator_Name()}">&gt;&gt;</a></td>
        </tr>
      </c:forEach>
      <tr>
        <td width="25%" align="center" height="16">&nbsp;</td>
        <td width="25%" align="center" height="16">&nbsp;</td>
        <td width="25%" align="center" height="16">&nbsp;</td>
        <td width="25%" align="center" height="16">&nbsp;</td>
      </tr>
    </table>
</BODY></HTML>
