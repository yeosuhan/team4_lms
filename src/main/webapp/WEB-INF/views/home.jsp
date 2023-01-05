<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<button type="button" class="btn btn-info"><fmt:message key="WRITE_NEW_ARTICLE"/></button>
<button type="button" class="btn btn-info"><fmt:message key="WRITE_NEW_ARTICLE"/></button>
<button type="button" class="btn btn-info"><fmt:message key="WRITE_NEW_ARTICLE"/></button>
<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
