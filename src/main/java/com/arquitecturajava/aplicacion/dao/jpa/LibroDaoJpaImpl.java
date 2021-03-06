package com.arquitecturajava.aplicacion.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.arquitecturajava.aplicacion.bo.Libro;
import com.arquitecturajava.dao.LibroDao;

public class LibroDaoJpaImpl extends GenericDaoJpaImpl<Libro, String> implements LibroDao {

	public List<Libro> buscarPorCategoria(String categoria) {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		TypedQuery<Libro> consulta = manager.createQuery("select l from Libro l where l.categoria.id=?1", Libro.class);
		
		consulta.setParameter(1, categoria);
		List<Libro> listaDeLibros = null;
		
		try {
			listaDeLibros = consulta.getResultList();
		} finally {
			manager.close();
		}
		return listaDeLibros;
	}
	
	@Override
	public List<Libro> buscarTodos() {
		EntityManagerFactory factoriaSession = JPAHelper.getJPAFactory();
		EntityManager manager = factoriaSession.createEntityManager();
		List<Libro> listaDeObjetos = null;
		
		try {
			TypedQuery<Libro> consulta = manager.createQuery("select l from Libro l JOIN FETCH l.categoria", Libro.class);
			listaDeObjetos = consulta.getResultList();
			return listaDeObjetos;
		} finally {
			manager.close();
		}
	}
}
