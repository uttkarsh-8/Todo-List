<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Add a todo</title>
    <link
      rel="stylesheet"
      href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
    />
  </head>
  <body>
    <%@ include file="common/navigation.jspf"%>
    <div class="container">
      <h1>Enter Todo Details</h1>
      <form:form action="" method="post" modelAttribute="todo">
        <fieldset class="mb-3">
          <form:label path="description"> Description</form:label>
          <form:input type="text" path="description" />
          <form:errors path="description" cssClass="text-warning" />
        </fieldset>
        <fieldset class="mb-3">
          <form:label path="targDate">Target Date:</form:label>
          <form:input type="date" path="targDate" />
          <form:errors path="targDate" cssClass="text-warning" />
        </fieldset>

        <form:input type="hidden" path="id" />

        <form:input type="hidden" path="done" />

        <input type="submit" class="btn btn-success" />
      </form:form>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/js/jquery.min.js"></script>
  </body>
</html>
