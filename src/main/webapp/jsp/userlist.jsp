<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Management</title>
</head>
<style>
    table {
        border-collapse: collapse;
        width: 100%;
    }    th, td {
             text-align: left;
             padding: 8px;
             border: 1px solid #ddd;
         }

    th {
        background-color: #f2f2f2;
    }

    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
</style>

<body>
<table>
    <tr>
        <th>ID</th>
        <th>Username</th>
        <th>Email</th>
        <th>Password</th>
        <th>Role</th>
    </tr>
    <c:forEach items="${user}" var="account">
        <tr>
            <td>${account.userId}</td>
            <td>${account.userName}</td>
            <td>${account.userEmail}</td>
            <td>${account.password}</td>
            <td>${account.userType}</td>
            <td><a href="/music/backend/user/delete/${account.userId}">Delete</a></td>
        </tr>
    </c:forEach>
    <%-- Show success message if any --%>


</table>
</body>
</html>
