<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <form action="/" method="post">
            <input name='description'/>
            <input type='submit' value='Create'/>
        </form>
    </body>
</html>