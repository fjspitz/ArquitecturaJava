package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.dao.DaoAbstractFactory;
import com.arquitecturajava.aplicacion.dao.LibroDao;

public class InsertarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");
		String titulo = request.getParameter("titulo");
		String categoria = request.getParameter("categoria");
		
		LibroDao libroDao = DaoAbstractFactory.getInstance().getLibroDao();
		Libro libro = new Libro(isbn, titulo, new Categoria(categoria));
		libroDao.insertar(libro);
		return "MostrarLibros.do";
	}

}
