<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY>
    <form method="POST" action="addAccount?Account_ID=${Account_ID}">
      <p>账号：<input type="text" name="T1" size="20" value="${Account_ID}" readonly></p>
      <p>姓名：<input type="text" name="T2" size="20"></p>
      <p>联系地址：<input type="text" name="T3" size="20"></p>
      <p>开户金额：<input type="text" name="T4" size="20"></p>
      <p><input type="submit" value="提交" name="B1"><input type="reset" value="全部重写" name="B2"></p>
    </form>
    <div height="30"><div align="center"><strong style="color: red">${tip}</strong>
    </div></div>
</BODY></HTML>
