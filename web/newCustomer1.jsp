<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY>
    <form method="POST" action="addCustomer?id=${tCustomer.getID_Type()}&number=${tCustomer.getID_Number()}&tCustomer=${tCustomer}">
      <p>证件类型：${tCustomer.getID_Type() == 'D' ? '居民身份证' : tCustomer.getID_Type() == 'A' ? '护照' : '军官证'}</p>
      <p>证件号码：${tCustomer.getID_Number()}</p>
      <p>姓名：<input type="text" name="T1" size="20"></p>
      <p>性别：<input type="radio" value="0" checked name="R1">男&nbsp;&nbsp; <input type="radio" name="R1" value="1">女</p>
      <p>生日：<input type="text" name="T3" size="20"></p>
      <p>联系地址：<input type="text" name="T4" size="20"></p>
      <p>　</p>
      <p><input type="submit" value="下一步>>" name="B1"><input type="reset" value="全部重写" name="B2"></p>
    </form>
    <div height="30"><div align="center"><strong style="color: red">${tip}</strong>
    </div></div>
</BODY></HTML>
