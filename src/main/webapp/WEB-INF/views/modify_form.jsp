<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글 수정</h2>
	<hr>
	<form action="boardModify">
	<table border=1 cellpadding=3 cellspacing=0>
	<tr>
		<th>글번호</th>
		<td>${bDto.bnum }<input type="hidden" name="bnum" value="${bDto.bnum }"></td>
	</tr>
	<tr>
		<th>글제목</th>
		<td><input type="text" name="btitle" value="${bDto.btitle }"></td>
	</tr>
	<tr>
		<th>글쓴이</th>
		<td><input type="text" name="bname" value="${bDto.bname}"></td>
	</tr>
	<tr>
		<th>내용</th>
		<td><textarea rows="10" cols="60" name="bcontent">${bDto.bcontent }</textarea> </td>
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
	<input type="submit">
	</form>
		
</body>
</html>