package com.arquitecturajava.aplicacion.dao.hibernate;

import com.arquitecturajava.dao.CategoriaDao;
import com.arquitecturajava.dao.DaoFactory;
import com.arquitecturajava.dao.LibroDao;

public class DaoHibernateFactory implements DaoFactory {
	public CategoriaDao getCategoriaDao() {
		return new CategoriaDaoHibernateImpl();
	}
	
	public LibroDao getLibroDao() {
		return new LibroDaoHibernateImpl();
	}
}
