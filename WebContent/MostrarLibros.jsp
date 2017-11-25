<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.arquitecturajava.DataBaseHelper" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Lista de libros</title>
</head>
<body>
<%
	ResultSet rs = null;
	
	try {
		String consultaSQL = "select isbn, titulo, categoria from Libros";
		DataBaseHelper dbh = new DataBaseHelper();
		rs = dbh.seleccionarRegistros(consultaSQL);

		while(rs.next()) {	%>
			<%= rs.getString("isbn") %>
			<%= rs.getString("titulo") %>
			<%= rs.getString("categoria") %>
			<br/>
		<% }
	} catch (SQLException e) {
		System.out.println("Error accediendo a la base de datos: " + e.getMessage());
	} finally {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.out.println("Error cerrando el resultset: " + e.getMessage());
			}
		}
	}
	%>
	<a href="FormularioInsertarLibro.jsp">Insertar libro</a>
</body>
</html>