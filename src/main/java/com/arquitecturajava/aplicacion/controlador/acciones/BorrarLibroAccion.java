package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;
 
public class BorrarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServicioLibros servicioLibros = (ServicioLibros) getBean("ServicioLibros", request);
		String isbn = request.getParameter("isbn");
		Libro libro = servicioLibros.buscarLibroPorClave(isbn);
		servicioLibros.borrarLibro(libro);
		return "MostrarLibros.do";
	}

}
