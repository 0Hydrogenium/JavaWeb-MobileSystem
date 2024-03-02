<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
    <META http-equiv=Content-Type content="text/html; charset=gb2312">
    <META content="MSHTML 6.00.2600.0" name=GENERATOR>
    <link href="style.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY>
<form method="POST" action="addOperator">
    <p>登录ID：<input type="text" name="T1" size="20"></p>
    <p>姓 名：<input type="text" name="T2" size="20"></p>
    <p>密码：<input type="password" name="T3" size="20"></p>
    <p>密码确认：<input type="password" name="T4" size="20"></p>
    <p>是否管理员：<input type="radio" name="R1" value="V1" checked>是&nbsp;&nbsp;&nbsp;
        <input type="radio" name="R1" value="V2">否</p>
    <p><input type="submit" value="提交" name="B1"></p>
</form>
<div height="30"><div align="center"><strong style="color: red">${tip}</strong>
</div></div>
</BODY></HTML>

