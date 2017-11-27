<?xml version="1.0" encoding="UTF-8"?>

<%@ page import="java.util.List" %>
<%@ page import="com.arquitecturajava.aplicacion.Libro"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
	<head>
		<script type="text/javascript" src="js/validacion.js"></script>
		<link rel="stylesheet" type="text/css" href="css/formato.css" />
		<title>Formulario Libro</title>
	</head>
	<body>
		<form id="miformulario" action="InsertarLibro.do" onsubmit="return validacion();" >
			<fieldset>
				<legend>Formulario alta libro</legend>
				<p><label for="isbn">ISBN:</label><input type="text" id="isbn" name="isbn"/><br/></p>
				<p><label for="titulo">Titulo:</label><input type="text" id="titulo" name="titulo"/><br/></p>
				<p><label for="categoria">Categoria:</label>
				
				<select name="categoria">
					<c:forEach var="categoria" items="${listaDeCategorias}">
						<option value="${categoria}">${categoria}</option>
					</c:forEach>
				</select>
				<br/>
				</p>
				<p><input type="submit" value="Insertar" onclick="validacion()"/></p>
			</fieldset>
		</form>
	</body>
</html>
