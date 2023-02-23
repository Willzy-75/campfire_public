<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
  <h1 class="text_color">Enter User Story:</h1>
  <form:form method="post" modelAttribute="userStory" class="row g-3">

    <div class="col-md-6">
      <label for="name" class="form-label">Name</label>
      <form:input type="text" path="name" required="required" class="form-control" id="name" />
      <form:errors path="name" cssClass="text-warning" />
    </div>

    <div class="col-md-6">
      <label for="persona" class="form-label">Persona</label>
      <form:input type="text" path="persona" required="required" class="form-control" id="persona" />
      <form:errors path="persona" cssClass="text-warning" />
    </div>

    <div class="col-12">
      <label for="whatToDo" class="form-label">What to do?</label>
      <form:textarea path="whatToDo" required="required" class="form-control" id="whatToDo" rows="5"></form:textarea>
      <form:errors path="whatToDo" cssClass="text-warning" />
    </div>

    <div class="col-12">
      <label for="whyToDo" class="form-label">Why to do it?</label>
      <form:textarea path="whyToDo" required="required" class="form-control" id="whyToDo" rows="5"></form:textarea>
      <form:errors path="whyToDo" cssClass="text-warning" />
    </div>

    <div class="col-md-6">
      <label for="editable" class="form-label">Editable</label>
      <form:input type="text" path="editable" required="required" class="form-control" id="editable" />
      <form:errors path="editable" cssClass="text-warning" />
    </div>

    <div class="col-md-6">
      <label for="complexity" class="form-label">Complexity</label>
      <form:input type="text" path="complexity" required="required" class="form-control" id="complexity" />
      <form:errors path="complexity" cssClass="text-warning" />
    </div>
    
     <div class="col-md-6">
      <label for="urlInput" class="form-label">URL?</label>
      <form:input type="text" path="urlInput" required="required" class="form-control" id="urlInput" />
      <form:errors path="urlInput" cssClass="text-warning" />
    </div>

    <form:input type="hidden" path="id" />
    <div class="col-12">
      <input type="submit" class="btn btn-success" value="Submit">
    </div>

  </form:form>
</div>

<%@ include file="common/footer.jspf"%>