<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>File Upload</title>
<link rel="shortcut icon" type="image/x-icon" href="/advFiles/resources/favicon.ico">
<link href="/advFiles/resources/css/bootstrap.min.css" rel="stylesheet">
<link href="/advFiles/resources/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="/advFiles/resources/css/hello.css" rel="stylesheet">
</head>

<body role="document">

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/advFiles/f/upload">Home</a>
			</div>
		</div>
	</nav>

	<div class="container theme-showcase" role="main">

		<div class="jumbotron">

			<h3>Files</h3>

			<table class="table table-striped table-bordered table-hover table-condensed">
				<tr>
					<th>Files</th>
					<th>Delete</th>
				</tr>
				<c:forEach var="fileName" items="${fileList}" varStatus="loop">
					<tr>
						<td><c:out value="${fileName}" /></td>
						<td><form:form method="post" action="/advFiles/f/upload/deletefile" id="f${loop.index}">
								<input name="filename" id="filetodelete" type="hidden" value="${fileName}" />
								<input type="submit" value="Delete">
							</form:form></td>
					</tr>
				</c:forEach>
			</table>
		</div>



		<div class="row">
			<div class="col-sm-6">
				<div class="page-header">
					<h2>Select file to Upload</h2>
				</div>
				<p>
				<div>
					
						<c:if test="${param.fu eq true}">
        					<pre>File Uploaded Successfully !</pre>
						</c:if>
						<c:if test="${param.fd eq true}">
        					<pre>File deleted !</pre>
						</c:if>
						<c:if test="${param.vf eq true}">
        				<pre>Given File Name is not right Format Please choose right format file !</pre>
						</c:if>
					
					<ol>
						
						<form:form method="post" action="/advFiles/f/upload/savefile"
							enctype="multipart/form-data">

							<p>
								<input name="file" id="fileToUpload" type="file" />
							</p>
							<p>
								<input type="submit" value="Upload">
							</p>
						</form:form>
					</ol>
				</div>
				</p>
			</div>

		</div>



	</div>

	<div class="container">
		<hr>
		<footer>
			<p>&copy; Q 2017</p>
		</footer>
	</div>

	<script type="text/javascript" src="/advFiles/resources/js/hello.js"></script>
	<script type="text/javascript" src="/advFiles/resources/js/jquery-1.12.0.min.js"></script>
	<script type="text/javascript" src="/advFiles/resources/js/bootstrap.min.js"></script>

</body>
</html>