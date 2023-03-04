<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2023/2/18
  Time: 11:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach items="${brands}" var="brand">
    <table>
        <tr align="center">
            <td>${brand.id}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.description}</td>
        </tr>
    </table>

</c:forEach>

</body>
</html>
