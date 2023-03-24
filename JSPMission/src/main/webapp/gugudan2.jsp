<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력 Type JSP</title>
</head>
<body>
<% int col = Integer.parseInt(request.getParameter("col")); %>
<%-- int dan = Integer.parseInt(request.getParameter("dan"));--%>
<h2>구구단 출력</h2>
<ul>
<%
	for(int j=1; j<10; j=j+col){
%>
<%
	for(int i = 1; i < 10; i++) {
%>
<%
	for(int k=i; k<i; k++)
%>
	<%= j%>*<%= i %> = <%= j*i %> 
	<%--  k+"x"+j+"="+j*k+"\t" --%>

	<br/>
<%
	}
%>
<br/>
<%
}
%>

</ul>
</body>
</html>