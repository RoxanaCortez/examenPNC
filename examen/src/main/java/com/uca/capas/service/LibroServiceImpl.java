package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Libro;

@Service
public class LibroServiceImpl implements LibroService{
	@Autowired
	LibroDAO libroDao;

	@Override
	public List<Libro> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDao.findAll();
	}

	@Override
	public Libro findOne(Integer codigo) throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDao.findOne(codigo);
	}

	@Override
	public void insertar(Libro c) throws DataAccessException {
		// TODO Auto-generated method stub
		libroDao.insertar(c);
	}

	@Override
	public int delete(Libro c) throws DataAccessException {
		// TODO Auto-generated method stub
		return libroDao.delete(c);
	}

}
