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
<script type="text/javascript" src="script/board.js"></script>
</head>
<body>
	<div id="wrap" align="center">
		<h1>댓글 상세보기</h1>
		<table>
			<tr>
				<th>No.</th>
				<td ><input type="text" name="num" value="${board.num}"></td>
				
			</tr>
			<tr>
				<th>작성자</th>
				<td>${comment.name}</td>
				
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${comment.writedate}" /></td>
				<th>조회수</th>
				<td>${comment.readcount }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${comment.name }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${comment.subtitle }</pre></td>
			</tr>
		</table>
		<br> <br> <input type="button" value="댓글 수정"
			onclick="open_win('CommentServlet?command=board_check_pass_form&num=${board.num}', 'update')">
		<input type="button" value="댓글 삭제"
			onclick="open_win('CommentServlet?command=board_check_pass_form&num=${board.num}', 'delete')">
		<input type="button" value="댓글 리스트"
			onclick="location.href='CommentServlet?command=Comment_list'"> 
		
	</div>
</body>
</html>