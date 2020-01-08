<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"/>
</head>
<body>
<c:import url="../template/nav.jsp"/>

<div class="container">
	<h1>ID :  ${member.id}</h1>
	<h1>Name : ${member.name}</h1>
	<h1>Email : ${member.email}</h1>
	<h1>Photo</h1>
		<h1>${member.memberFilesVO.fname}</h1>
		<h1>${member.memberFilesVO.oname}</h1>
	
		<img alt="" src="../upload/${member.memberFilesVO.fname}">

		<a class="btn btn-primary" href="./memberFileDown?fnum=${member.memberFilesVO.fnum}">FileDown</a>		
		
		<a href="./memberUpdate?id=${member.id}" class = "btn btn-primary">회원수정</a>
		<a href="./memberDelete?id=${member.id}" class = "btn btn-danger">회원탈퇴</a>
</div>

</body>
</html>