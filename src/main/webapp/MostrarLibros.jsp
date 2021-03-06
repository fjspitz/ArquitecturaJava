<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista de libros</title>
</head>
<body>
	<form name="filtroCategoria" action="FiltrarLibrosPorCategoria.do">
		<select name="categoria">
			<option value="seleccionar">seleccionar</option>
			<c:forEach var="categoria" items="${listaDeCategorias}">
				<option value="${categoria.id}">${categoria.descripcion}</option>
			</c:forEach>
		</select>
		<input name="filtrar" type="submit" value="Filtrar"/>
	</form>
	<br/>
	
	<display:table list="${listaDeLibros}">
		<display:column property="isbn"	title="ISBN"/>
		<display:column property="titulo"		title="T�tulo"/>
		<display:column property="categoria.descripcion" title="Categor�a"/>
		<display:column title="Borrar" 
			href="BorrarLibro.do" 
			paramId="isbn" 
			paramProperty="isbn"> 
			Borrar
		</display:column>
		<display:column title="Editar" 
			href="FormularioEditarLibro.do"
			paramId="isbn" 
			paramProperty="isbn">
			Editar
		</display:column>
	</display:table>
	
	<!-- 
	<c:forEach var="libro" items="${listaDeLibros}">
		${libro.isbn} 
		${libro.titulo} 
		${libro.categoria.descripcion}
		<a href="BorrarLibro.do?isbn=${libro.isbn}">Borrar</a>
		<a href="FormularioEditarLibro.do?isbn=${libro.isbn}">Editar</a>
		<br/>
	</c:forEach>
	 -->
	<a href="FormularioInsertarLibro.do">Insertar libro</a>
</body>
</html>