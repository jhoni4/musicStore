<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp" %>
<br>
<br>
	<link href="./resources/css/tableStyle.css" rel="stylesheet">
	<script  src="http://jqueryjs.googlecode.com/files/jquery-1.3.2.min.js"></script>
	<!-- <!--[if IE]><script>
	$(document).ready(function() { 

$("#form_wrap").addClass('hide');

})

</script><![endif]--> -->

	<div id="wrap">
		<h1>Send a message</h1>
		<div id='form_wrap'>
			<form>
				<p>Hello Joe,</p>
				<label for="email">Your Message : </label>
				<textarea  name="message" value="Your Message" id="message" ></textarea>
				<p>Best,</p>	
				<label for="name">Name: </label>
				<input type="text" name="name" value="" id="name" />
				<label for="email">Email: </label>
				<input type="text" name="email" value="" id="email" />
				<input type="submit" name ="submit" value="Now, I send, thanks!" />
			</form>
		</div>
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp" %>



