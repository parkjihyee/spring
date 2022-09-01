<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<div><h3>회원 등록</h3></div>
	<div>
		<form id="frm" action="memberInsert.do" method="post">
			<div>
				<table border="1">
					<tr>
						<th width="100">아이디</th>
						<td width="100">
							<input type="text" id="memberId" name="memberId">
						</td>
						
						<th width="100">비밀번호</th>
						<td width="100">
							<input type="password" id="memberPassword" name="memberPassword">
						</td>
						
						<th width="100">이름</th>
						<td width="100">
							<input type="text" id="memberName" name="memberName">
						</td>
				</table>
			</div><br>
			<input type="submit" value="등록">
			<input type="reset" value="취소">
		</form>
	</div>	
	
</div>
</body>
</html>