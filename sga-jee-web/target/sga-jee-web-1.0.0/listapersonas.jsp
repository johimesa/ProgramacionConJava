<%-- 
    Document   : listapersonas
    Created on : 03-Jul-2020, 21:34:33
    Author     : Hilario
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Persona</title>
    </head>
    <body>
        <h1>Listado de Persona</h1>
        <ul>
            <c:forEach items="${personas}" var="persona">
                <li>${persona.idPersona} ${persona.nombre} ${persona.apellidos}</li>
            </c:forEach>
        </ul>
    </body>
</html>
