<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<link href="webjars/bootstrap/5.2.3/css/bootstrap.min.css" rel="stylesheet">
		<title>Campfire</title>
		<style>
		  	.text_color {
	      		color: green;
	    	}
	    	body {
	    		background-color: white;
	    	}
		</style>
	</head>
	
	<body>
		<%@ include file="common/navigation_client.jspf" %>
		<div class="container">
			<h1 class="text_color">Welcome to Campfire Stories, Engineer!</h1>
			<hr>
			<div><a href="list-todos" class="text_color">Manage</a> your to-do's.</div>
			<div><a href="list-users" class="text_color">View</a> users</div>
			<div><a href="list-user-story" class="text_color">Manage</a> your user stories</div>
			<div><a href="list-id-scraper" class="text_color">Manage</a> your id scrapers</div>
			<div><a href="generate-test-suite" class="text_color">Generate</a> a test suite</div>
		</div>
		<script src="webjars/bootstrap/5.2.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.3/jquery.min.js"></script>
	</body>
</html>