package com.tiago.bookstore.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tiago.bookstore.domain.Livro;
import com.tiago.bookstore.dto.LivroDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class LivroAssembler {

	@Autowired
	private ModelMapper modelMapper;

	/* METODOS SEM HATEOAS */
	public LivroDto toLivroDto(Livro livro) {
		return modelMapper.map(livro, LivroDto.class);
	}

	public List<LivroDto> toListLivroDto(List<Livro> livros) {
		return livros.stream().map(this::toLivroDto).collect(Collectors.toList());

	}

}
