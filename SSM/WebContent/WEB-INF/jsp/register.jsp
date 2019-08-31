<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>register.jsp</title>
</head>
<body>
	
	<h1>注册页面</h1>
	
	<form action="user/add" method="post">
		用户名:<input type="text" name="name"><br>
		年   龄:<input type="text" name="age"><br>
		生   日:<input type="text" name="dob"><br>
		<input type="submit" value="提交">
	</form>
	
</body>
</html>