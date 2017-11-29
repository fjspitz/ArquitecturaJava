package com.arquitecturajava.aplicacion.dao.jpa;

import com.arquitecturajava.aplicacion.dao.CategoriaDao;
import com.arquitecturajava.aplicacion.dao.DaoFactory;
import com.arquitecturajava.aplicacion.dao.LibroDao;

public class DaoJpaFactory implements DaoFactory {
	public CategoriaDao getCategoriaDao() {
		return new CategoriaDaoJpaImpl();
	}
	
	public LibroDao getLibroDao() {
		return new LibroDaoJpaImpl();
	}
}
