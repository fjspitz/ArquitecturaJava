<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList" %>    
<%@ page import="com.arquitecturajava.Libro" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista de libros</title>
</head>
<body>

<select name="categoria">
<option value="seleccionar">seleccionar</option>
<%
	ArrayList<String> listaDeCategorias = null;
	listaDeCategorias = Libro.buscarTodasLasCategorias();
	for (String categoria : listaDeCategorias) { 
%>
	<option value="<%=categoria%>">
		<%=categoria%>
	</option>
	<% }
%>

</select>
<br/>

<%
	ArrayList<Libro> listaDeLibros = null;
	listaDeLibros = Libro.buscarTodos();
	for (Libro libro : listaDeLibros) { %>
			<%=libro.getIsbn() %>
			<%=libro.getTitulo() %>
			<%=libro.getCategoria() %>
			<br/>
	<% } 
%>
	<a href="FormularioInsertarLibro.jsp">Insertar libro</a>
</body>
</html>