<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY>
    <form method="POST" action="addMobiles">
    <p>号码类型：<input type="Radio" name="R1" value="SIM" checked>SIM &nbsp;&nbsp;<input type="Radio" name="R1" value="UIM">UIM</p>
    <p>指定号段：从<input type="text" name="T1" size="20">
        到<input type="text" name="T2" size="20">
        <input type="submit" value="提交" name="B1">&nbsp;&nbsp;
        <input type="reset" value="全部重写" name="B2"></p>
    </form>
    <div height="30"><div align="center"><strong style="color: red">${tip}</strong>
    </div></div>
</BODY></HTML>
