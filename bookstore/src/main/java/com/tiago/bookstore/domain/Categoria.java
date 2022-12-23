package com.tiago.bookstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	
	
	/*@Getter(value = AccessLevel.NONE)
	@Setter(value = AccessLevel.NONE)*/
	@OneToMany(mappedBy = "categoria")
	private List<Livro> livro = new ArrayList<>();

	
	public Categoria(Integer id, String nome, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}

	
	
}
