<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY>
    <form method="POST" action="getCustomer">
      <p>证件类型：<select size="1" name="D1">
        <option value="D">居民身份证</option>
        <option value="A">护照</option>
        <option value="P">军官证</option>
      </select></p>
      <p>证件号码：<input type="text" name="T2" size="20"></p>
      <p>　</p>
      <p><input type="submit" value="下一步>>" name="B1"><input type="reset" value="全部重写" name="B2"></p>
    </form>
    <div height="30"><div align="center"><strong style="color: red">${tip}</strong>
    </div></div>
</BODY></HTML>
