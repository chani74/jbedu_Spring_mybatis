<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>boardContent</h2>
	<hr>
	<table border=1 cellpadding=3 cellspacing=0>
	<tr>
		<th>글번호</th>
		<td>${bDto.bnum }</td>
	</tr>
	<tr>
		<th>글제목</th>
		<td>${bDto.btitle }</td>
	</tr>
	<tr>
		<th>글쓴이</th>
		<td>${bDto.bname}</td>
	</tr>
	<tr>
		<th>내용</th>
		<td>${bDto.bcontent }</td>
	</tr>
	<tr>
		<th>작성시간</th>
		<td>${bDto.bdate }</td>
	</tr>
	<tr>
		<th>조회수</th>
		<td>${bDto.bhit }</td>
	</tr>
	
	</table>
	<a href="modify_form?bnum=${bDto.bnum }">글수정</a>
	<a href="deleteOk?bnum=${bDto.bnum }">글삭제</a>
	<a href="boardList">글목록</a><p>	
</body>
</html>