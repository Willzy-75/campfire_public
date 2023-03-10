<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation_client.jspf" %>
		
<div class="container">
	<h1 class="text_color">The ID Scrapers are:</h1>
	<hr>
	<table class="table">
		<thead>
			<tr>
				<th class="text_color">Name</th>
				<th class="text_color">URL</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${idScrapers}" var="idScraper">
				<tr>
					<td class="text_color">${idScraper.name}</td>
					<td class="text_color">${idScraper.url}</td>
					<td><a href="delete-id-scraper?id=${idScraper.id}"
						class="btn btn-warning">Delete</a></td>
					<td><a href="update-id-scraper?id=${idScraper.id}"
						class="btn btn-success">Update</a></td>
					<td><a href="run-id-scraper?url=${idScraper.url}"
						class="btn btn-success">Run ID Scraper</a></td>
				</tr>
			</c:forEach>
		</tbody>	
	</table>	
	<a href="add-id-scraper" class="btn btn-success">Add Id Scraper</a>



	<table class="table">
		<thead>
			<tr>
				<th class="text_color">URL</th>
				<th class="text_color">Ids</th>
			</tr>
		<tbody>
			<c:forEach items="${ids}" var="id">
				<tr>
					<td class="text_color">${url}</td>
					<td class="text_color">${id}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</div>
		
<%@ include file="common/footer.jspf" %>