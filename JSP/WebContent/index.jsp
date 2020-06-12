<%--
  Created by IntelliJ IDEA.
  User: Hilario
  Date: 31/05/2020
  Time: 05:07 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP - Introducción</title>
</head>
<body>
    <h1>Generación de Reporte Excel</h1>
    <a href="ReporteExcel.jsp">Reporte Excel</a>
    <br /><br />
    <!-- Ejemplos de inclusión -->
    <ul>
        <li><%@include file="paginas/noticias.html" %> </li>
        <li><%@include file="paginas/noticias2.jsp" %></li>
    </ul>
    <br />
    <a href="expressionLanguage.jsp?usuario=hilario">Expression Language</a>
    <br />
    <a href="ejemploJSTL.jsp?opcion=4">Ir al JSP de JSTL Core</a>
</body>
</html>
