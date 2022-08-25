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
<c:forEach items="${notices }" var="n">
	${n.NOTICE_ID } : ${n.NOTICE_WRITER } : ${n.NOTICE_TITLE } <br> 
	<!-- vo 안 만들고 list에 담아서(map사용시) sql 컬럼명이랑 동일하게 쓰기 -->
	<!-- LIST MAP으로 만들면 JSON객체로 날라와서 만들기 쉬움. -->
</c:forEach>
</body>
</html>