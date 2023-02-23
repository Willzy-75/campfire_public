<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation_client.jspf" %>
		
<div class="container">
	<h1 class="text_color">The Users Stories are:</h1>
	<hr>
	<table class="table">
		<thead>
			<tr>
				<th class="text_color">Name</th>
				<th class="text_color">Persona</th>
				<th class="text_color">What to do?</th>
				<th class="text_color">Why to do it?</th>
				<th class="text_color">Editable?</th>
				<th class="text_color">Complexity</th>
				<th class="text_color">URL</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${userStories}" var="userStory">
				<tr>
					<td class="text_color">${userStory.name}</td>
					<td class="text_color">${userStory.persona}</td>
					<td class="text_color">${userStory.whatToDo}</td>
					<td class="text_color">${userStory.whyToDo}</td>
					<td class="text_color">${userStory.editable}</td>
					<td class="text_color">${userStory.complexity}</td>
					<td class="text_color">${userStory.urlInput}</td>
					<td><a href="delete-user-story?id=${userStory.id}"
						class="btn btn-warning">Delete</a></td>
					<td><a href="update-user-story?id=${userStory.id}"
						class="btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-user-story" class="btn btn-success">Add User Story</a>
</div>
		
<%@ include file="common/footer.jspf" %>