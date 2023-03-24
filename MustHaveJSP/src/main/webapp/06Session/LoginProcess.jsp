<%@page import="membership.MemberDTO"%>
<%@page import="membership.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//if
	String userId= request.getParameter("user_id");
	String userPwd= request.getParameter("user_pw");
	
	String mysqlDriver = application.getInitParameter("mysqlDriver");
	String mysqlURL = application.getInitParameter("mysqlURL");
	String mysqlID = application.getInitParameter("mysqlId");
	String mysqlPwd = application.getInitParameter("mysqlPwd");
	
	MemberDAO dao = new MemberDAO(mysqlDriver,mysqlURL,mysqlID,mysqlPwd);
	MemberDTO memberDTO = dao.getMemberDTO(userId, userPwd);
	dao.close();
	
	if(memberDTO.getId() !=null){
		session.setAttribute("UserId", memberDTO.getId());
		session.setAttribute("UserName", memberDTO.getName());
		response.sendRedirect("LoginForm.jsp");
	}
/* 	if(userId.equals("musthave") && userPwd.equals("tiger")){
		session.setAttribute("user_id",userId);
		session.setAttribute("UserName", userId);
		response.sendRedirect("LoginForm.jsp");
	} */
	else{
		request.setAttribute("LoginErrMsg", "로그인오류입니다.");
		request.getRequestDispatcher("LoginForm.jsp").forward(request,response);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>