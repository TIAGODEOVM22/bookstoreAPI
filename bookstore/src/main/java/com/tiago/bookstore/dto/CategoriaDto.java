package com.tiago.bookstore.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Relation (collectionRelation = "Categorias") /*altera array de Links CategoriaDtoList para Categorias */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaDto extends RepresentationModel<CategoriaDto> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String descricao;
	
}
