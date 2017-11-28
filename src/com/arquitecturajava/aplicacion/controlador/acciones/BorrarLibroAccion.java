package com.arquitecturajava.aplicacion.controlador.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.dao.LibroDao;
import com.arquitecturajava.aplicacion.dao.jpa.LibroDaoJpaImpl;

public class BorrarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		LibroDao libroDao = new LibroDaoJpaImpl();
		String isbn = request.getParameter("isbn");
		Libro libro = libroDao.buscarPorClave(isbn);
		libroDao.borrar(libro);
		return "MostrarLibros.do";
	}

}
