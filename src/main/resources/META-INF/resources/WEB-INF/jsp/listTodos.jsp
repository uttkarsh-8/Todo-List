<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
  <head>
    <link
      rel="stylesheet"
      href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
    />
    <title>List Todos Page</title>
  </head>
  <body>
    <%@ include file="common/navigation.jspf"%>
    <div class="container">
      <h1>Your Todos</h1>
      <table class="table">
        <thead>
          <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
            <th></th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${todos}" var="todo">
            <tr>
              <td>${todo.description}</td>
              <td>${todo.targDate}</td>
              <td>${todo.done}</td>
              <td>
                <a href="update-todo?id=${todo.id}" class="btn btn-warning"
                  >UPDATE</a
                >
              </td>
              <td>
                <a href="delete-todo?id=${todo.id}" class="btn btn-danger"
                  >DELETE
                </a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      <a href="add-todo" class="btn btn-success">Add todo!!</a>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/js/jquery.min.js"></script>
  </body>
</html>
