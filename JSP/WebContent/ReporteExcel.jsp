<%@page errorPage="/WEB-INF/manejoErrores.jsp" %>
<%@ page import="com.util.Conversiones, java.util.Date" %>
<%@ page contentType="application/vnd.ms-excel" pageEncoding="UTF-8" %>
<%
    String nombreArchivo = "reporte.xls";
    //response.setHeader("Content-Disposition", "attachment;filename=" + nombreArchivo);
    response.setHeader("Content-Disposition", "inline;filename=" + nombreArchivo);
    //inline para q sea posible ver la pag. de error
%>
<html>
    <head>
        <title>Reporte de Excel</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripción</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <td>1. Fundamentos de Java</td>
                <td>Aprenderemos la sintaxis básica de Java</td>
                <td><%=Conversiones.format("500")%> </td>
            </tr>
            <tr>
                <td>2. Programación con Java</td>
                <td>Pondremos en práctica la POO</td>
                <td><%=Conversiones.format(new Date())%> </td>
            </tr>
        </table>
    </body>
</html>
