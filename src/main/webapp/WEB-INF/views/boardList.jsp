<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 게시판 글 목록</h2>
	<hr>
	<table border=1 cellpadding=3 cellspacing=0>
	<tr>
		<th>글 번호 </th>
		<th>글 제목</th>
		<th>글쓴이</th>
		<th>조회수</th>
	</tr>	
	<c:forEach var="bDto" items="${bDtos }">
	<tr>
		<th>${bDto.bnum }</th>
		<th><a href='boardContent?bnum=${bDto.bnum }'> ${bDto.btitle }</a></th>
		<th>${bDto.bname }</th>
		<th>${bDto.bhit }</th>
	</tr>
	</c:forEach>
	</table>
	<a href="write_form">글쓰기</a>
	<a href="delete_form">글삭제</a>	
</body>
</html>