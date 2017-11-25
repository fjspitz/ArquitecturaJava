<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.arquitecturajava.DataBaseHelper" %> 

<%
	String isbn = request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	
	// Realizo la consulta usando el DBHelper y el código queda simplificado	
	String consultaSQL = "insert into libros (isbn, titulo, categoria) values ";
	consultaSQL += "('" + isbn + "','" + titulo + "','" + categoria + "')";
	
	DataBaseHelper dbh = new DataBaseHelper();
	int filas = dbh.modificarRegistro(consultaSQL);
	
	response.sendRedirect("MostrarLibros.jsp");
%>