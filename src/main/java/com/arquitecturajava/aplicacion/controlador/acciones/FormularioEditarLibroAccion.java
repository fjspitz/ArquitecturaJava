package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;

public class FormularioEditarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		ServicioLibros servicioLibros = (ServicioLibros) getBean("servicioLibros", request);
		String isbn = request.getParameter("isbn");
		
		List<Categoria> listaDeCategorias = servicioLibros.buscarCategoriasLibros();
		Libro libro = servicioLibros.buscarLibroPorClave(isbn);
		
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("libro", libro);
		return "FormularioEditarLibro.jsp";
	}
}
