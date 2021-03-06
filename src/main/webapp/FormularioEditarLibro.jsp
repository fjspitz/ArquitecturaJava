<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Editar libro</title>
</head>
<body>
	<form id="formularioEdicion" action="ModificarLibro.do">
		<fieldset>
			<legend>Formulario de edici�n de libro</legend>
			<p><label for="isbn">ISBN:</label>
			<input readonly="readonly" type="text" id="isbn" name="isbn" value="${libro.isbn}"/></p>
			<p><label for="titulo">Titulo:</label>
			<input type="text" id="titulo" name="titulo" value="${libro.titulo}"/></p>
			<p><label for="categoria">Categor�a:</label>
			<select name="categoria">
				<c:forEach var="categoria" items="${listaDeCategorias}">
					<option value="${categoria.id}" <c:if test="${categoria.id == libro.categoria.id}">selected</c:if>>${categoria.descripcion}</option>
				</c:forEach>
			</select>
			<br/></p>
			<p><input type="submit" value="Salvar"/></p>
		</fieldset>
	</form>
</body>
</html>