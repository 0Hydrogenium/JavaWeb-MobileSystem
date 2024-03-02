<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY>
  <p>证件类型：${tCustomer.getID_Type() == 'D' ? '居民身份证' : tCustomer.getID_Type() == 'A' ? '护照' : '军官证'}</p>
  <p>证件号码：${tCustomer.getID_Number()}</p>
  <p>姓名：${tCustomer.getCustomer_Name()}</p>
  <p>性别：${tCustomer.getCustomer_Sex() == '0' ? '男' : '女'}</p>
  <p>生日：${tCustomer.getCustomer_Birthday()}</p>
  <p>联系地址：${tCustomer.getCustomer_Address()}</p>
  <p>　</p>
  <p></p>
</BODY></HTML>
