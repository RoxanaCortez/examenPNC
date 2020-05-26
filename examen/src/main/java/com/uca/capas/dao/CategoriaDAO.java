package com.uca.capas.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Categoria;

public interface CategoriaDAO {
	public List<Categoria>findAll() throws DataAccessException;
	
	public Categoria findOne(Integer codigo) throws DataAccessException;
	
	void insertar(Categoria c) throws DataAccessException;
	
	int delete(Categoria c) throws DataAccessException;
}
