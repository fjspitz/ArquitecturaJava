package com.arquitecturajava.aplicacion.dao.hibernate;

import com.arquitecturajava.aplicacion.dao.CategoriaDao;
import com.arquitecturajava.aplicacion.dao.DaoFactory;
import com.arquitecturajava.aplicacion.dao.LibroDao;

public class DaoHibernateFactory implements DaoFactory {
	public CategoriaDao getCategoriaDao() {
		return new CategoriaDaoHibernateImpl();
	}
	
	public LibroDao getLibroDao() {
		return new LibroDaoHibernateImpl();
	}
}
