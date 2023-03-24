<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력 Type JSP</title>
</head>
<body>
<% int dan = Integer.parseInt(request.getParameter("dan"));%>

<h2>구구단 <%= dan%>단 출력</h2>
<ul>
<%
	for(int i = 1; i < 10; i++) {
%>
	<%= dan%>*<%= i %> = <%= dan*i %> 
	<br>
<%
	}
%>


</ul>
</body>
</html>