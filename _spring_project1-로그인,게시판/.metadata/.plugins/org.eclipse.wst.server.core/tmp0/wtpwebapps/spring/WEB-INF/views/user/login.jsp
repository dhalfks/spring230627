<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<h1>LogIn Page</h1>
<form action="/member/login" method="post">
ID : <input type="text" name="id" placeholder="아이디">
PassWord: <input type="password" name="pw" placeholder="패스워드">
<button type="submit">login</button>
</form>

</body>
</html>