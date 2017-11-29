package com.arquitecturajava.aplicacion.controlador.acciones;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.dao.CategoriaDao;
import com.arquitecturajava.dao.DaoAbstractFactory;
import com.arquitecturajava.dao.DaoFactory;
import com.arquitecturajava.dao.LibroDao;

public class MostrarLibrosAccion extends Accion {

	@Override
	public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
		DaoFactory factoria = DaoAbstractFactory.getInstance();
		LibroDao libroDao = factoria.getLibroDao();
		CategoriaDao categoriaDao = factoria.getCategoriaDao();
		
		List<Libro> listaDeLibros = libroDao.buscarTodos();
		List<Categoria> listaDeCategorias = categoriaDao.buscarTodos();
		
		request.setAttribute("listaDeLibros", listaDeLibros);
		request.setAttribute("listaDeCategorias", listaDeCategorias);
		return "MostrarLibros.jsp";
	}
}
