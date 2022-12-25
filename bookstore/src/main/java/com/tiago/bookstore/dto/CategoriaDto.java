package com.tiago.bookstore.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaDto implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String nome;
	private String descricao;
	
}
