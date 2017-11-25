<%@ page isErrorPage="true" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Página de errores</title>
</head>
<body>
	<p>Ha ocurrido un error en la aplicación: <%=exception.getMessage()%></p>
	<p>Error interno: <%=exception.getCause().getMessage()%></p>
</body>
</html>