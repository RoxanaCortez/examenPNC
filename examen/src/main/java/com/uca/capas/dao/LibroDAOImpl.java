package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO{
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	
	//Método para obtener todos los contribuyentes
	@Override
	public List<Libro> findAll() throws DataAccessException { 
		StringBuffer sb = new StringBuffer();    //objeto StringBuffer
		sb.append("select * from public.cat_libro");	//definiendo consulta
		Query query = entityManager.createNativeQuery(sb.toString(),Libro.class);
		List<Libro>resulset=query.getResultList();	//obtenemos lista de contribuyentes
		return resulset;
	}
	
	@Override
	public Libro findOne(Integer codigo) throws DataAccessException {
		Libro l = entityManager.find(Libro.class, codigo);
		return l;
	}
	
	@Override
	@Transactional
	public void insertar(Libro l) throws DataAccessException {
		
		if(l.getIdLibro() == null) { //Si llave primaria viene vacío, entonces es un INSERT
			entityManager.persist(l); //Utilizamos persist
		}
		else { //Caso contrario, se buscó al contribuyente
			entityManager.merge(l); //Utilizamos merge ya que es un UPDATE
		}
		
	}
	
	@Override
	@Transactional
	public int delete(Libro l) throws DataAccessException {
		try {
			entityManager.remove(entityManager.contains(l) ? l : entityManager.merge(l));
			entityManager.flush();	
			return 1;
		}catch(Throwable ex) {
			ex.printStackTrace();
			return 1;
		}
	}
}
