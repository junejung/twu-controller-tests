<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Hello World!</title>
    </head>
    <body>
        <h1>Hello There</h1>
        <h2>Things to do:</h2>
        <c:forEach var="todo" items="${todos}">
            <div>${todo.description}</div>
        </c:forEach>
    </body>
</html>