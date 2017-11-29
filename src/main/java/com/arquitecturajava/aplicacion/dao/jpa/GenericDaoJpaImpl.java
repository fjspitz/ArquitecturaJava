package com.arquitecturajava.aplicacion.dao.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.arquitecturajava.dao.GenericDao;

public abstract class GenericDaoJpaImpl<T, Id extends Serializable> implements GenericDao<T, Id> {
	private static final Logger log = Logger.getLogger("GenericDaoJpaImpl");
	private Class<T> claseDePersistencia;
	private EntityManagerFactory entityManagerFactory;
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}
	
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	
	@SuppressWarnings("unchecked")
	public GenericDaoJpaImpl() {
		this.claseDePersistencia = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public T buscarPorClave(Id id) {
		EntityManager manager = getEntityManagerFactory().createEntityManager();
		T objeto = null;
		
		try {
			objeto = (T) manager.find(claseDePersistencia, id);
			return objeto;
		} finally {
			manager.close();
		}
	}

	@Override
	public List<T> buscarTodos() {
		EntityManager manager = getEntityManagerFactory().createEntityManager();
		List<T> listaDeObjetos = null;
		
		try {
			TypedQuery<T> consulta = manager.createQuery("select o from " + claseDePersistencia.getSimpleName() + " o", claseDePersistencia);
			listaDeObjetos = consulta.getResultList();
			return listaDeObjetos;
		} finally {
			manager.close();
		}
	}
	
	@Override
	public void insertar(T objeto) {
		EntityManager manager = getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		
		log.info("Por agregar un elemento en la base");
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.persist(objeto);
			tx.commit();
			log.info("Se agregó el elemento a la base");
		} catch (PersistenceException e) {
			log.severe("Se produjo un error al guardar: " + e.getMessage());
			tx.rollback();
			throw e;
		} finally {
			manager.close();
		}
	}

	@Override
	public void salvar(T objeto) {
		EntityManager manager = getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.merge(objeto);
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			throw e;
		} finally {
			manager.close();
		}
	}

	@Override
	public void borrar(T objeto) {
		EntityManager manager = getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		
		try {
			tx = manager.getTransaction();
			tx.begin();
			manager.remove(manager.merge(objeto));
			tx.commit();
		} catch (PersistenceException e) {
			tx.rollback();
			throw e;
		} finally {
			manager.close();
		}
	}
}
