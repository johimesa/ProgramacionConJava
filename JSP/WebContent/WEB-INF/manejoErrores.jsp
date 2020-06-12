<%--
  Created by IntelliJ IDEA.
  User: Hilario
  Date: 03/06/2020
  Time: 08:43 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@page isErrorPage="true" %>
<%@page import="java.io.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Página de Error</title>
</head>
<body>
    <h1>Página de error</h1>

    Ocurrió una excepción: <%= exception.getMessage() %>
    <br />
    <pre>
        <% exception.printStackTrace(new PrintWriter(out)); %>
    </pre>
</body>
</html>
