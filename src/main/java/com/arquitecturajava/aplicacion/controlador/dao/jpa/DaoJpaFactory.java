package com.arquitecturajava.aplicacion.controlador.dao.jpa;

import com.arquitecturajava.dao.CategoriaDao;
import com.arquitecturajava.dao.DaoFactory;
import com.arquitecturajava.dao.LibroDao;

public class DaoJpaFactory implements DaoFactory {
	public CategoriaDao getCategoriaDao() {
		return new CategoriaDaoJpaImpl();
	}
	
	public LibroDao getLibroDao() {
		return new LibroDaoJpaImpl();
	}
}
