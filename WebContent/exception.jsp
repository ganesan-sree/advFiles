<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forgot Password</title>
</head>
<body>
<c:forEach items="${exception.stackTrace}" var="element">
    <c:out value="${element}"/>
</c:forEach>
<h1>Exceptionnnnnn !!!!!!!!!!!!!!!!!!!!!!!!!!!!</h1>

<br/>
<br/>
<br/>
<c:if test="${not empty error}">
<c:out value="${error}"></c:out>
</c:if>
 
</body>
</html>