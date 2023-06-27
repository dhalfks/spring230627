<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List Page</title>
</head>
<body>
<h1>Board List Page</h1>
<table border="1">
 	<thead>
      <tr>
        <th width="10%">번호</th>
        <th width="30%">제목</th>
        <th width="20%">작성자</th>
        <th width="30%">작성일</th>
        <th width="10%">조회수</th>
       </tr>
    </thead>
    <tbody>
      <c:forEach items="${list}" var="board">
	      <tr>
	        <td>${board.bno}</td>
	        <td><a href="/board/detail?bno=${board.bno }">${board.title}</a></td>
	        <td>${board.writer}</td>
	        <td>${board.reg_date}</td>
	        <td>${board.read_count}</td>
	      </tr>
      </c:forEach>
    </tbody>
</table>
<!-- paging Line -->
<div>
<c:if test="${ph.prev }">
<a href="/board/list?pageNo=${ph.startPage -1 }&qty=${ph.pgvo.qty}"> ◀ </a>
</c:if>

<c:forEach begin="${ph.startPage }" end="${ph.endPage }" var="i">
	 <a href="/board/list?pageNo=${i }&qty=${ph.pgvo.qty}"> ${i } | </a>
</c:forEach>

<c:if test="${ph.next }">
<a href="/board/list?pageNo=${ph.endPage +1 }&qty=${ph.pgvo.qty}"> ▶ </a>
</c:if>
</div>
</body>
</html>