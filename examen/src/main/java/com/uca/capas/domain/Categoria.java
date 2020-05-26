package com.uca.capas.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table (schema = "public", name = "cat_categoria")
public class Categoria {
	@Id
	@Column(name = "c_categoria")
	private Integer idCategoria;
	
	@Column(name = "s_categoria")
	@Size(message="La categoria no debe tener mas de 50 caracteres", max = 50)
	@NotEmpty(message="Este campo no puede estar vacío")
	private String	categoria;
	
}
