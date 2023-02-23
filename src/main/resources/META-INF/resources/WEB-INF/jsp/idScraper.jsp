<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation_client.jspf"%>

<div class="container">
  <h1 class="text_color">Enter Id Scraper:</h1>
  <form:form method="post" modelAttribute="idScraper" class="row g-3">

    <div class="col-md-6">
      <label for="name" class="form-label">Name</label>
      <form:input type="text" path="name" required="required" class="form-control" id="name" />
      <form:errors path="name" cssClass="text-warning" />
    </div>

    <div class="col-md-6">
      <label for="url" class="form-label">URL</label>
      <form:input type="text" path="url" required="required" class="form-control" id="url" />
      <form:errors path="url" cssClass="text-warning" />
    </div>

    <form:input type="hidden" path="id" />
    <div class="col-12">
      <input type="submit" class="btn btn-success" value="Submit">
    </div>

  </form:form>
</div>

<%@ include file="common/footer.jspf"%>