<%@page import="com.coeding.mvc.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
	<html>
<head>
<meta charset="UTF-8">
<title>View:Article</title>
</head>
<body>
<%
	UserVO userVO = (UserVO)request.getAttribute("user");
%>
	<section>
		<article>
			<h2> <%=userVO.getUid() %><a href="edit.do?uid=<%=userVO.getUid() %>"><%=userVO.getName()  %></a></h2>
			<p><%=userVO.getName()  %> -- <%=userVO.getEmail() %>--<%=userVO.getPasswd() %> </p>
			
		</article>
	</section>
</body>
</html>