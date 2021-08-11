<%@page import="com.coeding.mvc.vo.UserVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List User</title>
</head>
<body>
		<% Object att = request.getAttribute("userList");
		List<UserVO> list = (List<UserVO>)att;
		for(UserVO vo : list){
		
		%>
		
		<h6> <%=vo.getUid() %>--<a href="view.do?uid=<%=vo.getUid() %>">--<%=vo.getName() %></a>--<%=vo.getEmail()%>--<%=vo.getPasswd() %></h6>
		
		
		
		<% } %>
</body>
</html>

