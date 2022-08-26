<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

</style>
<script src="resources/js/jquery-3.6.0.min.js"></script>
</head>

<body>
<div align="center">
	<div><h2>공지사항 LIST</h2></div>
	<div>
		<table>
			<tr>
				<td width="100">
					<select id="key" name="key">
						<option value="1">제목</option>
						<option value="2">내용</option>
						<option value="3">작성자</option>
					</select>
				</td>
				
				<td width="100">
					<input type="text" id="val" name="val">
				</td>
				<td width="100">
					<button type="button" onclick="searchCall()">검색</button>
				</td>
			</tr>
		</table>
		
	
		<table id="list">
			<thead>
				<tr>
					<th width="60">글 번호</th>
					<th width="100">작성자</th>
					<th width="200">제목</th>
					<th width="100">작성일자</th>
					<th width="50">조회수</th>
				</tr>
			</thead>

			<tbody id="tb">
			 <c:if test="${empty notices }">
			  <tr>
			   <td colspan="6" align="center">게시글이 존재하지 않습니다.</td>
			  </tr>
			 </c:if>
			 
			<c:forEach items="${notices }" var="N">
				<tr class="colored" onclick="noticeCall(${N.NOTICE_ID})">
					<td>${N.NOTICE_ID }</td>
					<td>${N.NOTICE_WRITER }</td>
					<td>${N.NOTICE_TITLE }</td>
					<td>${N.NOTICE_DATE }</td>
					<td>${N.NOTICE_HIT }</td> 
					<c:choose>
					  <c:when test="${not empty N.NOTICEATTECH }">
					   <td align="center">@</td>
					  </c:when>
					<c:otherwise>
					  <td align="center"></td>
					</c:otherwise>
					</c:choose>
				</tr> 
				</c:forEach>
			</tbody>	
		</table>
		</div>	 
	<!-- vo 안 만들고 list에 담아서(map사용시) sql 컬럼명이랑 동일하게 쓰기 -->
	<!-- LIST MAP으로 만들면 JSON객체로 날라와서 만들기 쉬움. -->

<div>
	<form id="frm" method="post">
		<input type="hidden" id="noticeId" name="noticeId">
	</form>
</div>
</div>

<script type="text/javascript">
 function noticeCall(id){
	frm.noticeId.value=id;
	frm.action = "noticeSelect.do";
	frm.submit();
}
 
//Post방식
/*
function searchCall(){ // ajax 검색처리
	let key = document.getElementById('key').value;
	let val = document.getElementById('val').value;
	
	fetch("ajaxSearch.do", {
		method : 'post',
		headers : {
			'Content-Type' : 'application/x-www-form-urlencoded',
		},
		body : 'key='+key+'&val='+val
	   })
	   .then(response => response.json())
	   //.then((data) => console.log(data))
	   .then(data => htmlView(data))
	}
	
		//json 형태로 값을 전달할 때
			headers:{
				'Contetn-Type' : 'application/json',
			},
			body: JSON.stringify({'key':key, 'val':val}) */
	   
			
			
	   // 제이쿼리 ajax로. (직관적)
 	   function searchCall(){
		let key = document.getElementById('key').value;
		let val = document.getElementById('val').value;
		$.ajax({
			url : "ajaxSearch.do",
			type : "post",
			data : {"key" : key, "val" : val},
			dataType : "json",
			success : function(response){ // 혹은 (data)
				console.log(response);	
				htmlView(response);
			},
			error : function(){
				
			}
		});
	} 
	
	function htmlView(data){
		//html로 변환해서 원하는 위치에 출력하도록 구현한다.
        $("#tb").remove();
        
        var tbody = $("<tbody id='tb' />");
        $.each(data, function(index, item){
           var row = $("<tr />").append(
                    $("<td />").text(item.noticeNo),
                    $("<td />").text(item.noticeWriter),
                    $("<td><a href=${n.noticeTitle}</a></td>").text(item.noticeTitle),
                    $("<td />").text(item.noticeDate),
                    $("<td />").text(item.noticeHit),
                    $("<td />").text(item.noticeattech),
                        
                 );
           tbody.append(row);
        });
        $("#list").append(tbody);
  }
  
	
</script>
</body>
</html>