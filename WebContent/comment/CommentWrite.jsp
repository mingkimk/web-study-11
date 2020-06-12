<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1>댓글 등록</h1>
		<form name="frm" method="post" action="CommentServlet">
			<input type="hidden" name="command" value="Comment_write">
			<table>
				<tr>
					<th>No.</th>
				<td ><input type="text" name="num" value="${board.num}"></td>
				</tr>

				<tr>
					<th>작성자</th>
					<td><input type="text" name="id"> * 필수</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" size="70" name="name"> * 필수</td>
				</tr>
				<tr>
					<th>댓글내용</th>
					<td><textarea cols="70" rows="15" name="subtitle"></textarea></td>
				</tr>
			</table>
			<br> <br> <input type="submit" value="등록"
				onclick="return boardCheck()"> <input type="reset"
				value="다시 작성"> <input type="button" value="목록"
				onclick="location.href='CommentServlet?command=Comment_list&num=${board.num}'">
		</form>
	</div>
</body>
</html>