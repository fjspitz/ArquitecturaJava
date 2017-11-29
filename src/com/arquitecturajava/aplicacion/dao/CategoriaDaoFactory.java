package com.arquitecturajava.aplicacion.dao;
import com.arquitecturajava.aplicacion.dao.hibernate.CategoriaDaoHibernateImpl;
import com.arquitecturajava.aplicacion.dao.jpa.CategoriaDaoJpaImpl;

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
