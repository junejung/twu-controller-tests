<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Errors!</title>
</head>
<body>
    <c:forEach var="error" items="${errors}">
        <div>${error.key} : ${error.value}</div>
    </c:forEach>
</body>
</html>