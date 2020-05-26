package com.uca.capas.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.domain.Categoria;


public interface CategoriaService {
	public List<Categoria>findAll() throws DataAccessException;
	
	public Categoria findOne(Integer codigo) throws DataAccessException;
	
	void insertar(Categoria c) throws DataAccessException;
	
	int delete(Categoria c) throws DataAccessException;
}
