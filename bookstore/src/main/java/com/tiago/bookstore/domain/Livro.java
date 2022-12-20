package com.tiago.bookstore.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Livro implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String titulo;
	private String nome_autor;
	private String texto;
	
	private Categoria categoria;
	
}
