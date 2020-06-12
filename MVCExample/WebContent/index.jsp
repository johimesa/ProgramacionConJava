<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MCV</title>
</head>
<body>
		
	<a href="${ pageContext.request.contextPath }/ServletController">Ir a Mostrar Variables</a>
	<br/><br/><br/>
	${ mensaje }
	<br /><br />
	<a href="${ pageContext.request.contextPath }/ServletControlador">
		Link al Servlet controlador SIN parámetros
	</a>
	<br/><br />
	<a href="${ pageContext.request.contextPath }/ServletControlador?accion=addVar">
		Link al Servlet controlador para agregar las variables
	</a>
	<br/><br />
	<a href="${ pageContext.request.contextPath }/ServletControlador?accion=displayVar">
		Link al Servlet controlador para listar las variables
	</a>
</body>
</html>