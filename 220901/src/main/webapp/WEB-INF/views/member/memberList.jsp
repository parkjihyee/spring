<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원 목록</h2>
	<c:forEach items="${members}" var="m">
		${m.memberId } : ${m.memberPassword } : ${m.memberName} : ${m.memberAuthor}<br/>
	</c:forEach>
</body>
</html>