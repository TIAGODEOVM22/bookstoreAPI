package com.tiago.bookstore.dto;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDto extends RepresentationModel<LivroDto> implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String titulo;
	private String nome_autor;
	private String texto;
	
	
}
