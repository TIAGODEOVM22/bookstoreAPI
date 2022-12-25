package com.tiago.bookstore.assembler;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.tiago.bookstore.domain.Categoria;
import com.tiago.bookstore.dto.CategoriaDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CategoriaAssembler {

	private ModelMapper modelMapper;
	
	public CategoriaDto toCategoriaDto(Categoria categoria) {
		return modelMapper.map(categoria, CategoriaDto.class);
	}
	
	public List<CategoriaDto> toListCategoriaDto(List<Categoria> categorias){
		return categorias.stream()
				.map(this::toCategoriaDto)
				.collect(Collectors.toList());
	}
	
}
