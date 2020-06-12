<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
		<h1>댓글 리스트</h1>
		<table class="list">
			<tr>
			
			<td>접속자 ${sessionScope.userid}</td>
				<td colspan="5" style="border: white; text-align: right"><a
					href="CommentServlet?command=Comment_write_form">댓글 등록</a></td>
			</tr>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			
			</tr>
			<c:forEach var="board" items="${commentList }">
				<tr class="record">
					<td>${board.num }</td>
					<td><a href="BoardServlet?command=Board_view&num=${board.num}">
							${comment.name } </a></td>
					<td>${comment.id}</td>
					<td><fmt:formatDate value="${comment.writedate }" /></td>
				
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>