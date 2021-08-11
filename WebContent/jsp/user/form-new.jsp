<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New:Article</title>
</head>
<body>
	<div>
		<form method="POST" action="join.do">
		<label>Name</label>
		<input type="text" name="name">
		<label>Email</label>
		<input type="text" name="email">
		<label>Passwd</label>
		<input type="password" name="passwd">
		<input type="submit" value="SEND">
		</form>
	</div>
</body>
</html>