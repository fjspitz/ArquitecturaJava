package com.arquitecturajava.aplicacion.servicios;

import java.util.List;

import com.arquitecturajava.aplicacion.bo.Categoria;
import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.dao.CategoriaDao;
import com.arquitecturajava.dao.LibroDao;

public interface ServicioLibros {
	
	public LibroDao getLibroDao();
	
	public void setLibroDao(LibroDao libroDao);
	
	public CategoriaDao getCategoriaDao();
	
	public void setCategoriaDao(CategoriaDao categoriaDao);
	
	public void salvarLibro(Libro libro);
	
	public void borrarLibro(Libro libro);
	
	public List<Libro> buscarTodosLosLibros();
	
	public List<Categoria> buscarCategoriasLibros();
	
	public Libro buscarLibroPorClave(String isbn);
	
	public Categoria buscarCategoriaPorClave(String id);
	
	public List<Libro> buscarLibrosPorCategoria(String categoria);
}
