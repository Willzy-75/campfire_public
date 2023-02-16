<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
		<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css">
		<title>Add Todo Page</title>
	</head>
	
	<body style="
		background-image: url('Campfire.jpeg');
		background-size: cover;
		background-repeat: no-repeat;
		background-attachment: fixed;"
	>
		<%@ include file="common/navigation.jspf" %>
		<div class="container">
			<style>
			  	.container {
	      	color: coral;
	    	}
  			</style>
			<div><h1>Welcome to Campfire Stories!</h1></div>

			<div><a href="list-todos">Manage</a> your to-do's.</div>
		</div>
		<script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.3/jquery.min.js"></script>
	</body>
</html>


