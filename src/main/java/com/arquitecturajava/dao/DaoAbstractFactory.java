package com.arquitecturajava.dao;

import com.arquitecturajava.aplicacion.controlador.dao.hibernate.DaoHibernateFactory;
import com.arquitecturajava.aplicacion.controlador.dao.jpa.DaoJpaFactory;

public abstract class DaoAbstractFactory {
	public static DaoFactory getInstance() {
		String tipo = "JPA";
		if (tipo.equals("Hibernate")) {
			return new DaoHibernateFactory();
		} else {
			return new DaoJpaFactory();
		}
	}
}
