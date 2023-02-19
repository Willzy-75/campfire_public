<th class="text_color">Why</th><%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
		<h1 class="text_color">Enter User Details:</h1>
		<form:form method="post" modelAttribute="user">
			
			<fieldset class="mb-3">
				<form:label path="username">Username</form:label>
				<form:input type="text" path="username" required="required"/>
				<form:errors path="username" cssClass="text-warning"/>						
			</fieldset>
			
			<fieldset class="mb-3">
				<form:label path="password">Password</form:label>
				<form:input type="text" path="password" required="required"/>
				<form:errors path="password" cssClass="text-warning"/>						
			</fieldset>
			
			<fieldset class="mb-3">
				<form:label path="usertype">User Type</form:label>
				<form:input type="text" path="usertype" required="required"/>
				<form:errors path="usertype" cssClass="text-warning"/>						
			</fieldset>
			
			<fieldset class="mb-3">
				<form:label path="email">User Email</form:label>
				<form:input type="text" path="email" required="required"/>
				<form:errors path="email" cssClass="text-warning"/>						
			</fieldset>
			
				<form:input type="hidden" path="id"/>
				<form:input type="hidden" path="loggedIn"/>
				<input type="submit" class="btn btn-success">
				
		</form:form>
</div>	

<%@ include file="common/footer.jspf" %>

