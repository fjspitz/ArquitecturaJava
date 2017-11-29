package com.arquitecturajava.aplicacion.dao;

public interface DaoFactory {
	public CategoriaDao getCategoriaDao();
	
	public LibroDao getLibroDao();
}
