<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<head>

<link href="<c:url value="/resources/css/loginStyle.css" />"
	rel="stylesheet">


</head>
<div id="login-box" class="box">
	<c:if test="${not empty msg}">
		<div class="msg">${msg}</div>
	</c:if>
	<form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
		<c:if test="${not empty error}">
			<div class="error" style="color: #fff;">${error}</div>
		</c:if>
		<div>Log in to your account or sign up to create one.</div>
		<div class="tag">SIGN IN</div>
		<div class="form-group">
			<label for="username">User: </label> 
			<input type="text" id="username" name="username" class="form-control" placeholder="Name:" />
		</div>
		<div class="form-group">
			<label for="password">Password:</label> 
			<input type="password" id="password" name="password" class="form-control" placeholder="Password:" />
		</div>

		<input type="submit" value="Submit" class="btn"> 
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>
