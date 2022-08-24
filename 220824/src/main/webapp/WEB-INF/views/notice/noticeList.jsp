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
<h2> 공지 목록</h2>
<c:forEach items = "${notices }" var="n">
	${n.notice_id } : ${n.notice_writer } : ${n.notice_title } : ${n.notice_subject } : ${n.date } : ${n.notice_hit } : ${n.notice_attech } : ${n.notice_attechdir } <br> 
</c:forEach>
<a href="noticeForm.do"> 글 등록 </a>
</body>
</html>