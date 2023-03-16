<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation_client.jspf"%>

<div class="container">
  <h1 class="text_color">Generate Page Factory:</h1>
  <form method="post" action="/generatePageFactory" enctype="multipart/form-data" class="row g-3">

    <div class="col-md-6">
      <label for="name" class="form-label">Name</label>
      <input type="text" name="name" required="required" class="form-control" id="name" />
    </div>

    <div class="col-md-6">
      <label for="packageName" class="form-label">Package Name</label>
      <input type="text" name="packageName" required="required" class="form-control" id="packageName" />
    </div>

    <div class="col-md-6">
      <label for="url" class="form-label">URL</label>
      <input type="text" name="url" required="required" class="form-control" id="url" />
    </div>

    <div class="col-md-6">
      <label for="outputDirectory" class="form-label">Output Directory</label>
      <input type="text" name="outputDirectory" required="required" class="form-control" id="outputDirectory" />
    </div>

    <div class="col-12">
      <input type="submit" class="btn btn-success" value="Submit">
    </div>

  </form>
</div>

<%@ include file="common/footer.jspf"%>
