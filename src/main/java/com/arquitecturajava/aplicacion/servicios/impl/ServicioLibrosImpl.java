package com.arquitecturajava.aplicacion.servicios.impl;

import java.util.List;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.aplicacion.servicios.ServicioLibros;
import com.arquitecturajava.dao.CategoriaDao;
import com.arquitecturajava.dao.LibroDao;

public class ServicioLibrosImpl implements ServicioLibros {
	
	private LibroDao libroDao = null;
	private CategoriaDao categoriaDao = null;

	public LibroDao getLibroDao() {
		return libroDao;
	}

	public void setLibroDao(LibroDao libroDao) {
		this.libroDao = libroDao;
	}

	public CategoriaDao getCategoriaDao() {
		return categoriaDao;
	}

	public void setCategoriaDao(CategoriaDao categoriaDao) {
		this.categoriaDao = categoriaDao;
	}

	@Override
	public void salvarLibro(Libro libro) {
		libroDao.salvar(libro);
	}

	@Override
	public void borrarLibro(Libro libro) {
		libroDao.borrar(libro);
	}

	@Override
	public List<Libro> buscarTodosLosLibros() {
		return libroDao.buscarTodos();
	}

	@Override
	public List<Categoria> buscarCategoriasLibros() {
		return categoriaDao.buscarTodos();
	}

	@Override
	public Libro buscarLibroPorClave(String isbn) {
		return libroDao.buscarPorClave(isbn);
	}

	@Override
	public Categoria buscarCategoriaPorClave(String id) {
		return categoriaDao.buscarCategoriaPorClave(id);
	}

	@Override
	public List<Libro> buscarLibrosPorCategoria(String categoria) {
		return libroDao.buscarPorCategoria(categoria);
	}

}
