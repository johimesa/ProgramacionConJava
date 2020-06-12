<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Muestra alcance Variables - MVC</title>
	</head>
	<body>
		Mensaje: ${ mensaje }<br/><br/>
		
		Variable en el alcance de Request: <br/>
		Base: ${ rect_req.base }<br/>
		Altura: ${ rect_req.altura }<br/>
		Área: ${ rect_req.area }<br/><br/>
		
		Variable en el alcance de Session: <br/>
		Base: ${ rect_session.base }<br/>
		Altura: ${ rect_session.altura }<br/>
		Área: ${ rect_session.area }<br/><br/>
		
		Variable en el alcance de Application: <br/>
		Base: ${ rect_app.base }<br/>
		Altura: ${ rect_app.altura }<br/>
		Área: ${ rect_app.area }<br/><br/>
	</body>
</html>