<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>



	<div class="box">
		<form>
			<div class="tag">SIGN IN</div>
			<div>Log in to your account or sign up to create one.</div>
			<div>
				<input type="text" id="inputName" placeholder="Name:">
			</div>
			<div>
				<input type="password" id="inputPassword" placeholder="Password:">
			</div>
			<div>
				<button type="submit" class="btn">SUBMIT</button>
			</div>
		</form>
	</div>
	
<%@include file="/WEB-INF/views/template/footer.jsp" %>
