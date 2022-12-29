package com.tiago.bookstore.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.tiago.bookstore.domain.Categoria;
import com.tiago.bookstore.dto.CategoriaDto;
import com.tiago.bookstore.resource.CategoriaResource;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class CategoriaAssembler {

	@Autowired
	private ModelMapper modelMapper;

	/*LINK FIXO APENAS TESTE O CERTO É DINAMICO*/
	/*public CategoriaDto toCategoriaDto(Categoria categoria) {
		CategoriaDto objDto = modelMapper.map(categoria, CategoriaDto.class);
		objDto.add(Link.of("http://localhost:8080/categorias/1"));
		return objDto;
	}*/
	
	/*RETORNA DE FORMA DINÂMICA MAS AINDA PODE SER MELHORADO UTILIZANDO APENAS O 
	 * MAPEAMENTO DA CLASSE E DO MÉTODO*/
	/*public CategoriaDto toCategoriaDto(Categoria categoria) {
		CategoriaDto objDto = modelMapper.map(categoria, CategoriaDto.class);
		objDto.add(WebMvcLinkBuilder.linkTo(CategoriaResource.class).slash(categoria.getId()).withSelfRel());
		return objDto;
	}**/
	
	public CategoriaDto toCategoriaDto(Categoria categoria) {
		CategoriaDto objDto = modelMapper.map(categoria, CategoriaDto.class);
		
		objDto.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(CategoriaResource.class)
				.findById(categoria.getId())).withSelfRel());
		
		objDto.add(linkTo(methodOn(CategoriaResource.class)
				.findAll()).withRel("categorias"));
		
		return objDto;
	}
	
	
	/*TRANSFORMA EM DTO SEM RETORNAR LINK*/
	/*public CategoriaDto toCategoriaDto(Categoria categoria) {
		return modelMapper.map(categoria, CategoriaDto.class);
	}*/


	public List<CategoriaDto> toListCategoriaDto(List<Categoria> categorias) {
		return categorias.stream().map(this::toCategoriaDto).collect(Collectors.toList());
	}

}
