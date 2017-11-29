package com.arquitecturajava.dao;

import com.arquitecturajava.aplicacion.controlador.dao.hibernate.CategoriaDaoHibernateImpl;
import com.arquitecturajava.aplicacion.controlador.dao.jpa.CategoriaDaoJpaImpl;

public class CategoriaDaoFactory { 
	public static CategoriaDao getInstance() {
		String tipo = "JPA";
		if (tipo.equals("Hibernate")) {
			return new CategoriaDaoHibernateImpl();
		} else {
			return new CategoriaDaoJpaImpl();
		}
	}
}
