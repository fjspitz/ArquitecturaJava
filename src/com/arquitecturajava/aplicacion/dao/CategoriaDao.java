package com.arquitecturajava.aplicacion.dao;

import java.util.List;

import com.arquitecturajava.aplicacion.bo.Categoria;

public interface CategoriaDao {
	
	public abstract List<Categoria> buscarTodos();
}
