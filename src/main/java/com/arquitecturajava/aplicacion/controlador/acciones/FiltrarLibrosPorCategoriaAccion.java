package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.dao.CategoriaDao;
import com.arquitecturajava.dao.DaoAbstractFactory;
import com.arquitecturajava.dao.LibroDao;

public class FiltrarLibrosPorCategoriaAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		CategoriaDao categoriaDao = DaoAbstractFactory.getInstance().getCategoriaDao();
		LibroDao libroDao = DaoAbstractFactory.getInstance().getLibroDao();
		
		List<Libro> listaDeLibros = null;
		List<Categoria> listaDeCategorias = categoriaDao.buscarTodos();

		if (request.getParameter("categoria") == null || request.getParameter("categoria").equals("seleccionar")) {
			listaDeLibros = libroDao.buscarTodos();
		} else {
			listaDeLibros = libroDao.buscarPorCategoria(request.getParameter("categoria"));
		}
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);

		return "MostrarLibros.jsp";
	}

}
