<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
안녕하세요.<br>조성진입니다.
</h1>
<c:forEach items="${list}" var="list">
	<strong style="font-size: 30px">[${list.reviewId}]</strong>님의 포인트는 => <strong style="font-size: 30px">[${list.totalpoint}]</strong> 입니다.<br>
</c:forEach>
<h1>
감사합니다.
</h1>
</body>
</html>
