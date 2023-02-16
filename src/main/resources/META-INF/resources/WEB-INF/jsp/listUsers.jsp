<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
		
<div class="container">
	<h1 class="text_color">The Users are:</h1>
	<hr>
	<table class="table">
		<thead>
			<tr>
				<th class="text_color">Name</th>
				<th class="text_color">Password</th>
				<th class="text_color">Email</th>
				<th class="text_color">Logged in?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td class="text_color">${user.username}</td>
					<td class="text_color">${user.password}</td>
					<td class="text_color">${user.email}</td>
					<td class="text_color">${user.loggedIn}</td>
					<td><a href="delete-user?id=${user.id}"
						class="btn btn-warning">Delete</a></td>
					<td><a href="update-user?id=${user.id}"
						class="btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-user" class="btn btn-success">Add User</a>
</div>
		
<%@ include file="common/footer.jspf" %>