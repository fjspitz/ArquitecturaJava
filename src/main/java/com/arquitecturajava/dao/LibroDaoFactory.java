package com.arquitecturajava.dao;

import com.arquitecturajava.aplicacion.controlador.dao.hibernate.LibroDaoHibernateImpl;
import com.arquitecturajava.aplicacion.controlador.dao.jpa.LibroDaoJpaImpl;

public class LibroDaoFactory {
	public static LibroDao getInstance() {
		String tipo = "JPA";
		if (tipo.equals("Hibernate")) {
			return new LibroDaoHibernateImpl();
		} else {
			return new LibroDaoJpaImpl();
		}
	}
}
