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
	<div><h1>공지사항 등록</h1></div>
	<div>
		<form id="frm" action="noticeInsert.do" method="post" enctype="multipart/form-data">
			<div>
				<table border="1">
					<tr>
						<th width="150">작성자</th>
						<td width="200">
							<input type="text" id="notice_writer" name="notice_writer"> <!-- VO 이름과 동일하게 쓰기 -->
						</td>
						<th width="150">작성일자</th>
						<td width="200">
							<input type="date" id="date" name="date">
						</td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3">
							<input type="text" id="notice_title" name="notice_title" size="80">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">
							<textarea rows="10" cols="80" id="notice_subject" name="notice_subject"></textarea>
						</td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td colspan="3">
							<input type="file" id="file" name="file">
						</td>
					</tr>										
				</table>
			</div><br>
			<input type="submit" value="등록">
			<input type="reset" value="취소">
		</form>
	</div>
</div>
</body>
</html>