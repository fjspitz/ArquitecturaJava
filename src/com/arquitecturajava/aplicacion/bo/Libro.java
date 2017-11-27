package com.arquitecturajava.aplicacion.bo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name="libros")
public class Libro {
	@Id 
	private String isbn;
	private String titulo;
	@ManyToOne
	@JoinColumn(name="categoria")
	private Categoria categoria;
	
	/**
	 * Este constructor gen�rico se a�ade para permitir el uso de gen�ricos 
	 * en la clase DataBaseHelper.
	 */
	public Libro() {}
	
	@Override
	public int hashCode() {
		return isbn.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		String isbnLibro = ((Libro)o).getIsbn();
		return isbnLibro.equals(isbn);
	}
	
	public Libro(String isbn) {
		super();
		this.isbn = isbn;
	}
	
	public Libro(String isbn, String titulo, Categoria categoria) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Libro> buscarTodos() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		List<Libro> listaDeLibros = session.createQuery("from Libro libro right join fetch libro.categoria").list();
		session.close();
		return listaDeLibros;
	}

	@SuppressWarnings("unchecked")
	public static List<String> buscarTodasLasCategorias( ) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		String consulta = "select distinct libro.categoria from Libro libro";
		
		List<String> listaDeCategorias = session.createQuery(consulta).list();
		session.close();
		return listaDeCategorias;
	}
	
	public void insertar() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.save(this);
		session.getTransaction().commit();
	}
	
	public void borrar() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.delete(this);
		session.getTransaction().commit();
	}
	
	public void salvar() {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.saveOrUpdate(this);
		session.getTransaction().commit();
	}
	
	public static Libro buscarPorClave(String isbn) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		Libro libro = (Libro)session.get(Libro.class, isbn);
		session.close();
		return libro;
	}
	
	@SuppressWarnings("unchecked")
	public static List<Libro> buscarPorCategoria(String categoria) {
		SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		
		Query consulta = session.createQuery("from Libro libro where libro.categoria =:categoria");
		consulta.setString("categoria", categoria);
		List<Libro> listaDeLibros = consulta.list();
		session.close();
		return listaDeLibros;
	}
}
