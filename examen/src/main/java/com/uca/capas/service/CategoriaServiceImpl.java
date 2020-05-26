package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.CategoriaDAO;
import com.uca.capas.domain.Categoria;

@Service
public class CategoriaServiceImpl implements CategoriaService{
	@Autowired
	CategoriaDAO categoriaDao;

	@Override
	public List<Categoria> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return categoriaDao.findAll();
	}

	@Override
	public Categoria findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return categoriaDao.findOne(codigo);
	}

	@Override
	public void insertar(Categoria c) throws DataAccessException {
		// TODO Auto-generated method stub
		categoriaDao.insertar(c);
	}

	@Override
	public int delete(Categoria c) throws DataAccessException {
		// TODO Auto-generated method stub
		return categoriaDao.delete(c);
	}

}
