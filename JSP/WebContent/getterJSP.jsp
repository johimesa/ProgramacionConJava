<%--
  Created by IntelliJ IDEA.
  User: Hilario
  Date: 03/06/2020
  Time: 05:30 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Lectura de valores JavaBean</title>
    </head>
    <body>
        <h1>Lectura de valores del JavaBean</h1>
        <jsp:useBean id="rectangulo" class="com.johi.Rectangulo" scope="session" />
        Valor Base: <jsp:getProperty name="rectangulo" property="base" /> <br />
        Valor Altura: <jsp:getProperty name="rectangulo" property="altura" /> <br />
        Valor Área: <jsp:getProperty name="rectangulo" property="area"/> <!-- Se puede llamar a pesar q no es atributo -->
        <br />
        <a href="javaBean.jsp">Regresar al Java Beans</a>
    </body>
</html>
