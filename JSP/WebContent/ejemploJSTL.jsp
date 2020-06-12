<%--
  Created by IntelliJ IDEA.
  User: Hilario
  Date: 07/06/2020
  Time: 08:52 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ejemplo de JSP Standard Tag Library</title>
</head>
<body>
    <h1>Ejemplo de JSP Standard Tag Library - Core</h1>

    <!-- variables manipulation -->
    <c:set var="nombre" value="Hilario" />
    Variable nombre: <c:out value="${nombre}" />
    <br/><br/>
    Variables de código HTML: <c:out value="<h4>Hola</h4>" escapeXml="false" />
    <br/><br/>
    <c:set var="bandera" value="false" />
    <c:if test="${bandera }">
    	La bandera es verdadera.
    </c:if>
    <br/><br/>
    <c:if test="${ param.opcion != null }">
    	<c:choose>
    		<c:when test="${ param.opcion == 1 }">
    			La opción es 1
    		</c:when>
    		<c:when test="${ param.opcion == 2 }">
    			La opción es 2
    		</c:when>
    		<c:otherwise>
    			La opción es desconocida: ${param.opcion}
    		</c:otherwise>
    	</c:choose>
    </c:if>
    <br/><br/>
    <!-- iteración de una arreglo -->
    <%
    	String[] names = {"Juan", "Amelia", "Alberto", "Nilcer"};
    	request.setAttribute("nombresAttr", names);
    	// el JSTL va a buscar nombresAttr en ese orden -> page, request, session, application 
    %>
    <ul>
    	<c:forEach var="name" items="${nombresAttr}">
    		<li>Nombre: ${name}</li>
    	</c:forEach>
    </ul>
    <br/><br/>
    <a href="index.jsp">Ir al inicio</a>
</body>
</html>
