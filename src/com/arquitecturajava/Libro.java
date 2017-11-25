package com.arquitecturajava;

import java.util.List;

public class Libro {
	private String isbn;
	private String titulo;
	private String categoria;
	
	/**
	 * Este constructor genérico se añade para permitir el uso de genéricos 
	 * en la clase DataBaseHelper.
	 */
	public Libro() {}
	
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
}
