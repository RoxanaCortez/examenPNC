package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table (schema = "public", name = "cat_categoria")
public class Categoria {
	@Id
	@Column(name = "c_categoria")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCategoria;
	
	@Column(name = "s_categoria")
	@Size(message="El campo sobrepasa la cantidad de 50 caracteres", max = 50)
	@NotEmpty(message="El campo nombre categoria no puede estar vacío")
	private String	categoria;
	
	
	
	public Integer getIdCategoria() {
		return idCategoria;
	}



	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public Categoria(){
		super();
	}
	
}
