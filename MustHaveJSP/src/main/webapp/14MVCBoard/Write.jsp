<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 첨부형 게시판</title>
<script type="text/javascript">
	function vaildateForm(form) {
		if(form.name.value == ""){
			alert("작성자를 입력하세요.");
			form.name.focus();
			return false;
		}
		if(form.title.value == ""){
			alert("제목을 입력하세요.");
			form.title.focus();
			return false;
		}
		if(form.pass.value == ""){
			alert("비밀번호를 입력하세요.");
			form.pass.focus();
			return false;
		}
	}
</script>
</head>
<h2>파일 첨부형 게시판 - 글쓰기(Write)</h2>
<form name="writeFrm" method="post" enctype="multipart/form-data" action="../mvcboard/write.do" onsubmit="return validateForm(this);">
<table border="1" width="90%">
	<tr>
		<td>작성자</td>
		<td>
			<input type="text" name="title" style="width:150px;"/>
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea name="content" style="width:90%;height:100px;"></textarea>
		</td>
	</tr>
	<tr>
		<td>첨부 파일</td>
		<td>
			<input type="file" name="ofile"/>
		</td>
	</tr>
</table>
<body>

</body>
</html>