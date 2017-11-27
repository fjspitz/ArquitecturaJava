<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %>    
<%@ page import="com.arquitecturajava.aplicacion.Libro" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista de libros</title>
</head>
<body>
	<form name="filtroCategoria" action="filtrar.do">
		<select name="categoria">
		<option value="seleccionar">seleccionar</option>
		<%
			List<String> listaDeCategorias = null;
			listaDeCategorias = (List<String>)request.getAttribute("listaDeCategorias");
			for (String categoria : listaDeCategorias) {
				if (categoria.equals(request.getParameter("categoria"))) {
			%>
			<option value="<%=categoria%>" selected><%=categoria%></option>
			<% } else { %>
			<option value="<%=categoria%>"><%=categoria%></option>
			<% }} %>
		</select>
		<input name="filtrar" type="submit" value="Filtrar"/>
	</form>
	<br/>
<%
	List<Libro> listaDeLibros = (List<Libro>)request.getAttribute("listaDeLibros");
	for (Libro libro : listaDeLibros) { %>
			<%=libro.getIsbn() %>
			<%=libro.getTitulo() %>
			<%=libro.getCategoria() %>
			<a href="BorrarLibro.do?isbn=<%=libro.getIsbn()%>">Borrar</a>
			<a href="FormularioEditarLibro.do?isbn=<%=libro.getIsbn()%>">Editar</a>
			<br/>
	<% } 
%>
	<a href="FormularioInsertarLibro.do">Insertar libro</a>
</body>
</html>