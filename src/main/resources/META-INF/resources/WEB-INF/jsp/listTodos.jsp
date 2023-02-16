<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
		
<div class="container">
	<h1 class="text_color">Your To-do's are:</h1>
	<hr>
	<table class="table">
		<thead>
			<tr>
				<th class="text_color">Name</th>
				<th class="text_color">Description</th>
				<th class="text_color">Target Date</th>
				<th class="text_color">Done?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td class="text_color">${todo.username}</td>
					<td class="text_color">${todo.description}</td>
					<td class="text_color">${todo.targetDate}</td>
					<td class="text_color">${todo.done}</td>
					<td><a href="delete-todo?id=${todo.id}"
						class="btn btn-warning">Delete</a></td>
					<td><a href="update-todo?id=${todo.id}"
						class="btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">Add Todo</a>
</div>
		
<%@ include file="common/footer.jspf" %>