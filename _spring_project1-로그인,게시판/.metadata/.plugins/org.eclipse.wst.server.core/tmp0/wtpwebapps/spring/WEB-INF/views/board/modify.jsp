<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Board Modify Page</h1>
<form action="/board/modify" method="post">
bno : <input type="text" name="bno" value="${board.bno }" readonly="readonly"><br>
title : <input type="text" name="title" value="${board.title }"><br>
writer : <input type="text" name="writer" value="${board.writer }" readonly="readonly"><br>
reg_date : <input type="text" name="reg_date" value="${board.reg_date }"><br>
content : <br>
<textarea rows="10" cols="30" name="content">${board.content }</textarea><br>
<button>수정</button>
</form>
<a href="/board/list"><button type="button">목록</button> </a>
<a href="/"><button type="button">home</button> </a>
</body>
</html>