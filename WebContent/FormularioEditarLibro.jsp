<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="com.arquitecturajava.Libro" %>
<%@ page import="java.util.List" %>
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
	<form id="formularioEdicion" action="SalvarLibro.jsp">
		<fieldset>
			<legend>Formulario de edici�n de libro</legend>
			<p><label for="isbn">ISBN:</label>
			<input type="text" id="isbn" name="isbn" value="<%=libro.getIsbn()%>"/></p>
			<p><label for="titulo">Titulo:</label>
			<input type="text" id="titulo" name="titulo" value="<%=libro.getTitulo()%>"/></p>
			<p><label for="categoria">Categor�a:</label>
			<select name="categoria">
			<%
				List<String> listaDeCategorias = null;
				listaDeCategorias = Libro.buscarTodasLasCategorias();
				for (String categoria : listaDeCategorias) {
					if (libro.getCategoria().equals(categoria)) { %>
					<option value="<%=categoria%>" selected="selected">
					<%=categoria%></option>
					<%} else {%>
					<option value="<%=categoria%>"><%=categoria%></option>
					<% }
				} %>
			</select>
			<br/></p>
			<p><input type="submit" value="Salvar"/></p>
		</fieldset>
	</form>
</body>
</html>