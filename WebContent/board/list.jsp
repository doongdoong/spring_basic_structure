<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h2>게시판</h2>
	<hr>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.no}</td>
				<td><a href="detail.do?no=${board.no}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.regtime}</td>
			</tr>
		</c:forEach>
	</table>
	<script>
		if('${msg}') {
			alert('${msg}');
		}
	</script>
</body>
</html>