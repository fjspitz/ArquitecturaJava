package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;

public class ModificarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		
		ServicioLibros servicioLibros = (ServicioLibros) getBean("servicioLibros", request);
		Libro libro = new Libro(isbn, titulo, new Categoria(categoria));
		servicioLibros.salvarLibro(libro);
		
		return "MostrarLibros.do";
	}
}
