<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.arquitecturajava.aplicacion.bo.Libro" %>
<%@ page import="java.util.List" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	Libro libro = Libro.buscarPorClave(request.getParameter("isbn"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Editar libro</title>
</head>
<body>
	<form id="formularioEdicion" action="ModificarLibro.do">
		<fieldset>
			<legend>Formulario de edición de libro</legend>
			<p><label for="isbn">ISBN:</label>
			<input type="text" id="isbn" name="isbn" value="${libro.isbn}"/></p>
			<p><label for="titulo">Titulo:</label>
			<input type="text" id="titulo" name="titulo" value="${libro.titulo}"/></p>
			<p><label for="categoria">Categoría:</label>
			<select name="categoria">
				<c:forEach var="categoria" items="${listaDeCategorias}">
					<option value="${categoria}">${categoria}</option>
				</c:forEach>
			</select>
			<br/></p>
			<p><input type="submit" value="Salvar"/></p>
		</fieldset>
	</form>
</body>
</html>