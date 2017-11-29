package com.arquitecturajava.aplicacion.dao;
import com.arquitecturajava.aplicacion.dao.hibernate.LibroDaoHibernateImpl;
import com.arquitecturajava.aplicacion.dao.jpa.LibroDaoJpaImpl;

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
