<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %> 
<%@ taglib prefix='sec' uri='http://www.springframework.org/security/tags' %>  

<html>
<body>
	<h3>Message : ${message}</h3>	
	<h3>Username : ${username}</h3>	
	<a href="<c:url value="/j_spring_security_logout" />" > Logout</a>
	<h1>Welcome! <sec:authentication property="principal.username"/></h1>
	
	
	<br></br>
	<h1>A The Authorize tag   "sec:authorize  ifAnyGranted="ROLE_ADMIN""</h1>
	<sec:authorize  ifAnyGranted="ROLE_ADMIN">
		<h1>Only admin can see this</h1>
		<br/>
		<a href="admin"> Admin Home </a>
	</sec:authorize>


<br/>
<br/>
<br/>
<h1>B The Authentication tag  sec:authentication property="credentials" ,  authentication property="authorities" var="roles" scope="page" , sec:authentication property="principal.username"</h1>
<!-- Credentials display -->
Your password is <sec:authentication property="credentials"/>
...
 
 <h1>sec:authentication property="authorities" var="roles" scope="page"</h1>
<!-- Roles display -->
<sec:authentication property="authorities" var="roles" scope="page" />
Your roles are:
<ul>
    <c:forEach var="role" items="${roles}">
    <li>${role}</li>
    </c:forEach>
</ul>
 
 <h1>sec:authentication property="principal.username"</h1>
<!-- Username display -->
Your username is <sec:authentication property="principal.username"/>



</body>
</html>