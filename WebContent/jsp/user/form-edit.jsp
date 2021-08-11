<%@page import="com.coeding.mvc.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit:Article</title>
</head>
<body>
<%
	UserVO userVO = (UserVO)request.getAttribute("userVO");
%>
	<div>
		<form action="edit.do" method="POST">
			<label>User ID</label>
            <input type="text" name="uid" value="<%=userVO.getUid()%>">
			<label>Name</label>
            <input type="text" name="name" value="<%=userVO.getName()%>"  required="required">
			<label>Email</label>
            <input type="text" name="email" value="<%=userVO.getEmail()%>">
            <label>Passwd</label>
			 <input type="text" name="passwd" value="<%=userVO.getPasswd()%>">
			<input type="submit" value="SEND">
		</form>

		</form>
	</div>


</body>
</html>