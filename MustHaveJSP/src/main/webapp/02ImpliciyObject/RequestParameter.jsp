<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>내장 객체 - request</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String sex = request.getParameter("sex");
String[] favo = request.getParameterValues("favo");
String favoStr="";
String intro1 = request.getParameter("intro1");
String intro = "Empty";
if (intro1 !=null){
	//for (int i = 0; i < favo.length;i++){
		//favoStr += favo[i] + " ";
	intro = intro1.replace("\r\n","<br/>");
	//}
}
//String intro = request.getParameter("intro").replace("\r\n", "<br/>");
%>
<ul>
	<li>아이디 : <%= id %></li>
	<li>성별 : <%= sex %></li>
	<li>관심사항 : <%= favoStr %></li>
	<li>자기소개 : <%= intro %></li>
</ul>
</body>
</html>