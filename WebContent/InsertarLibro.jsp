<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="com.arquitecturajava.Libro" %>
<%@ page import="com.arquitecturajava.DataBaseException" %>

<%
	String isbn = request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	
	Libro libro = new Libro(isbn, titulo, categoria);
	libro.insertar();
	response.sendRedirect("MostrarLibros.jsp");
%>