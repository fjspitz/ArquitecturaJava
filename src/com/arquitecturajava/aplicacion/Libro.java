package com.arquitecturajava.aplicacion;

import java.util.List;

public class Libro {
	private String isbn;
	private String titulo;
	private String categoria;
	
	/**
	 * Este constructor gen�rico se a�ade para permitir el uso de gen�ricos 
	 * en la clase DataBaseHelper.
	 */
	public Libro() {}
	
	public Libro(String isbn) {
		super();
		this.isbn = isbn;
	}
	
	public Libro(String isbn, String titulo, String categoria) {
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public static List<Libro> buscarTodos() {
		String consultaSQL = "select isbn, titulo, categoria from libros";
		DataBaseHelper<Libro> dbh = new DataBaseHelper<Libro>();
		List<Libro> listaDeLibros = dbh.seleccionarRegistros(consultaSQL, Libro.class);
		return listaDeLibros;
	}

	public static List<String> buscarTodasLasCategorias( ) {
		String consultaSQL = "select distinct(categoria) from libros";
		DataBaseHelper<String> dbh = new DataBaseHelper<String>();
		List<String> listaDeCategorias = dbh.seleccionarRegistros(consultaSQL, String.class);
		return listaDeCategorias;
	}
	
	public void insertar() {
		String consultaSQL = "insert into libros (isbn, titulo, categoria) values ";
		consultaSQL += "('" + this.isbn + "','" + this.titulo + "','" + this.categoria + "')";
		DataBaseHelper<Libro> dbh = new DataBaseHelper<Libro>();
		dbh.modificarRegistro(consultaSQL);
	}
	
	public void borrar() {
		String consultaSQL = "delete from libros where isbn = '" + this.isbn + "'";
		DataBaseHelper<Libro> dbh = new DataBaseHelper<Libro>();
		dbh.modificarRegistro(consultaSQL);
	}
	
	public static Libro buscarPorClave(String isbn) {
		String consultaSQL = "select isbn, titulo, categoria from libros where isbn='" + isbn + "'";
		DataBaseHelper<Libro> dbh = new DataBaseHelper<Libro>();
		List<Libro> listaDeLibros = dbh.seleccionarRegistros(consultaSQL, Libro.class);
		return listaDeLibros.get(0);
	}
	
	public void salvar() {
		String consultaSQL = "update libros set titulo='" + this.titulo + "', categoria='" + this.categoria + "' where isbn='" + isbn + "'";
		DataBaseHelper<Libro> dbh = new DataBaseHelper<Libro>();
		dbh.modificarRegistro(consultaSQL);
	}
	
	public static List<Libro> buscarPorCategoria(String categoria) {
		String consultaSQL = "select isbn, titulo, categoria from libros where categoria = '" + categoria + "'";
		DataBaseHelper<Libro> dbh = new DataBaseHelper<Libro>();
		List<Libro> listaDeLibros = dbh.seleccionarRegistros(consultaSQL, Libro.class);
		return listaDeLibros;
	}
}