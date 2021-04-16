<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>    
	<div id="navigation">
		<ul>
			<li><a href="<c:url value="/" var="url" />">Home</a></li>
			<li><a href="<c:url value="/guestbook" var="url" />">방명록</a></li>
			<li><a href="<c:url value="/board" var="url" />">게시판</a></li>
		</ul>
	</div>