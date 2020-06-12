<%--
  Created by IntelliJ IDEA.
  User: Hilario
  Date: 03/06/2020
  Time: 05:28 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>JSP que modifica JavaBeans</title>
    </head>
    <body>
        <jsp:useBean id="rectangulo" class="com.johi.Rectangulo" scope="session" />
        <%
            int base = 5;
            int altura = 10;
        %>
        <jsp:setProperty name="rectangulo" property="base" value="<%=base%>" />
        <jsp:setProperty name="rectangulo" property="altura" value="<%=altura%>" />

        <a href="getterJSP.jsp">Mostra valores del Bean</a>
    </body>
</html>
