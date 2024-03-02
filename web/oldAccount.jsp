<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY>
    <form method="POST">
      <p>账号：<input type="text" name="T1" size="20" value="${Account_ID}" readonly></p>
      <p>姓名：<input type="text" name="T2" size="20" value="${Contact_Person}" readonly></p>
      <p>联系地址：<input type="text" name="T3" size="20" value="${Contact_Address}" readonly></p>
      <p>账户余额：<input type="text" name="T4" size="20" value="${Account_Balance}" readonly></p>
      <p></p>
    </form>
    <div height="30"><div align="center"><strong style="color: red">${tip}</strong>
    </div></div>
</BODY></HTML>
