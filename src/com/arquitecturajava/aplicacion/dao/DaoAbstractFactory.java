package com.arquitecturajava.aplicacion.dao;

import com.arquitecturajava.aplicacion.dao.hibernate.DaoHibernateFactory;
import com.arquitecturajava.aplicacion.dao.jpa.DaoJpaFactory;

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
