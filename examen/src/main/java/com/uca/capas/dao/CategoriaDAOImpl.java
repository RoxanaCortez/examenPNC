package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Categoria;


@Repository
public class CategoriaDAOImpl implements CategoriaDAO{
	@PersistenceContext(unitName="capas")
	private EntityManager entityManager;

	
	//Método para obtener todos los contribuyentes
	@Override
	public List<Categoria> findAll() throws DataAccessException { 
		StringBuffer sb = new StringBuffer();    //objeto StringBuffer
		sb.append("select * from public.cat_categoria");	//definiendo consulta
		Query query = entityManager.createNativeQuery(sb.toString(),Categoria.class);
		List<Categoria>resulset=query.getResultList();	//obtenemos lista de contribuyentes
		return resulset;
	}
	
	@Override
	public Categoria findOne(Integer codigo) throws DataAccessException {
		Categoria c = entityManager.find(Categoria.class, codigo);
		return c;
	}
	
	@Override
	@Transactional
	public void insertar(Categoria c) throws DataAccessException {
		
		if(c.getIdCategoria() == null) { //Si llave primaria viene vacío, entonces es un INSERT
			entityManager.persist(c); //Utilizamos persist
		}
		else { //Caso contrario, se buscó al contribuyente
			entityManager.merge(c); //Utilizamos merge ya que es un UPDATE
		}
		
	}
	
	@Override
	@Transactional
	public int delete(Categoria c) throws DataAccessException {
		try {
			entityManager.remove(entityManager.contains(c) ? c : entityManager.merge(c));
			entityManager.flush();	
			return 1;
		}catch(Throwable ex) {
			ex.printStackTrace();
			return 1;
		}
	}
	
	
}
