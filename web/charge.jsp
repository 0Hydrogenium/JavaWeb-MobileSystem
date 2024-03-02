<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<HTML><HEAD><TITLE>中国移动业务管理系统</TITLE>
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 6.00.2600.0" name=GENERATOR>
<link href="style.css" rel="stylesheet" type="text/css">
</HEAD>
<BODY>
<h2>收费细项</h2>
    <form method="POST" action="updateCharge">
      <p>收费项目：<select size="1" name="D1">
        <option value="A">开户费</option>
        <option value="B">漫游费</option>
        <option value="C">押金</option>
        <option value="D">入网费</option>
        <option value="E">选号费</option>
      </select></p>
      <p>收费金额：<input type="text" name="T1" size="20"></p>
      <p><input type="submit" value="提交" name="B1"><input type="reset" value="全部重写" name="B2"></p>
    </form>
    <hr>
    <h2>业务收费</h2>
    <form method="POST" action="updateChargeRule">
      <p>业务：<select size="1" name="D1">
        <option value="O">开户业务</option>
      </select></p>
      <p>收费项目：<input type="checkbox" name="C1" value="ON">开户费
      <input type="checkbox" name="C2" value="ON">漫游费 <input type="checkbox" name="C3" value="ON">押金
      <input type="checkbox" name="C4" value="ON">入网费 <input type="checkbox" name="C5" value="ON">选号费</p>
      <p><input type="submit" value="提交" name="B1"><input type="reset" value="全部重写" name="B2"></p>
    </form>
    <div height="30"><div align="center"><strong style="color: red">${tip}</strong>
    </div></div>
</BODY></HTML>
