<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Portal</title>
<link rel="stylesheet" href="<c:url value="/assets/css/board.css" />" />
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<div id="wapper">
			<div id="content">
				<div id="site-introduction">
				
				
	<table border="1" width="640">
		<tr>
			<td colspan="6"><h3>게시판</h3></td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>작성일</th>
			<th>&nbsp;</th>
		</tr>
		<!-- Loop -->
		<c:forEach items="${list }" var="vo">
		<tr>
			<td>${vo.no }</td>
			<td><a href="">첫 번째 글입니다.</a></td>
			<td>${vo.memberName }</td>
			<td>${vo.hit }</td>
			<td>${vo.regDate }</td>
			<td><a href="">삭제</a></td>
		</tr>
		</c:forEach>
		<!-- /Loop -->
		<tr>
			<td colspan="6"><a href="">글쓰기</a></td>
		</tr>
	</table>



				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>