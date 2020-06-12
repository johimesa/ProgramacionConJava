<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Variables desde Servlet - MVC</title>
	</head>
	<body>
		Saludo desde Scope request: ${saludo}
		<br/><br/>
		Variable en alcance de Session: <br/>
		Base: ${ rectangle.base } <br />
		Altura: ${ rectangle.altura } <br />
		Área: ${ rectangle.area } <br /><br />
		
		<a href="${ pageContext.request.contextPath }/index.jsp">Ir al inicio</a>
	</body>
</html>