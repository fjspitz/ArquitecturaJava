<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Sentencias de import necesarias para JDBC -->
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.SQLException" %>

<%
	// 1
	String isbn = request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	
	Connection conexion = null;
	Statement sentencia = null;
	int filas = 0;
	
	// 2
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection(
				"jdbc:mysql://localhost/arquitecturajava",
				"arqjava",
				"arqjava");
		
		sentencia = conexion.createStatement();
		
		// 3
		String consultaSQL = "insert into Libros (isbn, titulo, categoria) values ";
		consultaSQL += "('" + isbn + "','" + titulo + "','" + categoria + "')";
		
		// 4
		filas = sentencia.executeUpdate(consultaSQL);
		
		response.sendRedirect("MostrarLibros.jsp");
	
	} catch (ClassNotFoundException e) {
		System.out.println("Error accediendo a la base de datos: " + e.getMessage());	
	} finally {
		// 5
		if (sentencia != null) {
			try {
				sentencia.close();
			} catch (SQLException e) {
				System.out.println("Error cerrando la sentencia: " + e.getMessage());
			}
		}
	}
%>