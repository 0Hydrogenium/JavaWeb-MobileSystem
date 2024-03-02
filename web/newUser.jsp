<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY>
 <form method="POST" action="addUser?Customer_ID=${Customer_ID}">
  <p>手机号码：<input type="text" name="T1" size="20"></p>
  <p>漫游状态：<input type="radio" name="R1" value="P" checked>省内漫游 <input type="radio" name="R1" value="D">国内漫游
  <input type="radio" name="R1" value="I">国际漫游</p>
  <p>通话级别：<input type="radio" value="L" checked name="R2">本地通话
  <input type="radio" name="R2" value="D">国内长途 <input type="radio" name="R2" value="I">国际长途</p>
  <p>客户ID：<input type="text" name="T2" size="20" value="${Customer_ID}" readonly></p>
  <p>账号：<input type="text" name="T3" size="20">  </p>
  <p><input type="submit" value="下一步>>" name="B1"><input type="reset" value="全部重写" name="B2"></p>
 </form>
 <div height="30"><div align="center"><strong style="color: red">${tip}</strong>
 </div></div>
</BODY></HTML>
