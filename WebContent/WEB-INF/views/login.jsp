<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>This is login page!</h1>
<form method="post" action="<c:url value='checkuser.do' />" >
用户ID：<input type="text" name="id" /><br/>
密码：<input type="password" name="password" /><br/>
<input type="submit" value="submit" />
</form>
</body>
</html>