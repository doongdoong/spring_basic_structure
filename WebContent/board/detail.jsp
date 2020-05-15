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
	<div>
		<div>
			<span>번호</span>
			<span>${board.no}</span>
		</div>
		<div>
			<span>제목</span>
			<span>${board.title}</span>
		</div>
		<div>
			<span>내용</span>
			<span>${board.content}</span>
		</div>
		<div>
			<span>등록일시</span>
			<span>${board.regtime}</span>
		</div>
		<div>
			<button id="listBtn">목록</button>
			<button id="deleteBtn">삭제</button>
		</div>
	</div>
	<script>
		$("#listBtn").click(e => {
			location.href = "list.do";
		});
		$("#deleteBtn").click(e => {
			location.href = "delete.do?no=${board.no}";
		});
	</script>
</body>
</html>