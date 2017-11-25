<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.arquitecturajava.Libro" %>

<%
	String isbn = request.getParameter("isbn");
	Libro libro = new Libro(isbn);
	libro.borrar();
	response.sendRedirect("MostrarLibros.jsp");
 %>