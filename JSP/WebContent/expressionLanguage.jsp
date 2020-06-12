<%--
  Created by IntelliJ IDEA.
  User: Hilario
  Date: 05/06/2020
  Time: 12:19 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Expression Language</title>
</head>
<body>
    <h1>Expression Language - EL</h1>

    <ul>
        <li>Nombre de la aplicación: ${pageContext.request.contextPath}</li>
        <li>Nombre del navegador: ${header["User-Agent"]} </li>
        <li>ID Session: ${cookie.JSESSIONID.value}</li>
        <li>Web Server: ${pageContext.servletContext.serverInfo}</li>
        <li>Valor enviado: ${param.usuario}</li>
    </ul>

</body>
</html>
