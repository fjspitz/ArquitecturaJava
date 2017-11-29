package com.arquitecturajava.dao;

public interface DaoFactory {
	public CategoriaDao getCategoriaDao();
	
	public LibroDao getLibroDao();
}
