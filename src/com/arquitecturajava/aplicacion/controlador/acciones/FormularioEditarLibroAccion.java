package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.dao.CategoriaDao;
import com.arquitecturajava.aplicacion.dao.LibroDao;
import com.arquitecturajava.aplicacion.dao.jpa.CategoriaDaoJpaImpl;
import com.arquitecturajava.aplicacion.dao.jpa.LibroDaoJpaImpl;

public class FormularioEditarLibroAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("isbn");
		
		CategoriaDao categoriaDao = new CategoriaDaoJpaImpl();
		LibroDao libroDao = new LibroDaoJpaImpl();
		List<Categoria> listaDeCategorias = categoriaDao.buscarTodos();
		Libro libro = libroDao.buscarPorClave(isbn);
		
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		request.setAttribute("libro", libro);
		return "FormularioEditarLibro.jsp";
	}
}
