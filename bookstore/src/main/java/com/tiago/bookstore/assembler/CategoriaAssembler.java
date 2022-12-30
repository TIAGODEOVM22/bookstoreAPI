package com.tiago.bookstore.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mediatype.hal.CollectionModelMixin;
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

	
	public CategoriaDto toCategoriaDto(Categoria categoria) {
		CategoriaDto objDto = modelMapper.map(categoria, CategoriaDto.class);
		
		/*Gera link para objDto de forma dinâmica através do metodo findById*/
		objDto.add(WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(CategoriaResource.class)
				.findById(categoria.getId())).withSelfRel());
		
		/*Gera link através do mapeamento da classeResource e seu mapeamento)*/
		objDto.add(linkTo(methodOn(CategoriaResource.class).findAll()).withRel("categorias"));

		return objDto;
	}
	
	/*Alterado de List p/ CollectionModel adicionando tudo dentro do Embedded*/
	public CollectionModel<CategoriaDto> toListCategoriaDto(List<Categoria> categorias) {
			var categoriaDto = CollectionModel.of(categorias.stream()
					.map(categoria -> toCategoriaDto(categoria)).
					collect(Collectors.toList()));
			
			/*gera Link para o próprio recurso dessa coleção*/
			categoriaDto.add(linkTo(methodOn(CategoriaResource.class).findAll()).withSelfRel());
			return categoriaDto;
	}
	
	/* LINK FIXO APENAS TESTE O CERTO É DINAMICO */
	/*
	 * public CategoriaDto toCategoriaDto(Categoria categoria) { CategoriaDto objDto
	 * = modelMapper.map(categoria, CategoriaDto.class);
	 * objDto.add(Link.of("http://localhost:8080/categorias/1")); return objDto; }
	 */

	/*
	 * RETORNA DE FORMA DINÂMICA MAS AINDA PODE SER MELHORADO UTILIZANDO APENAS O
	 * MAPEAMENTO DA CLASSE E DO MÉTODO
	 */
	/*
	 * public CategoriaDto toCategoriaDto(Categoria categoria) { CategoriaDto objDto
	 * = modelMapper.map(categoria, CategoriaDto.class);
	 * objDto.add(WebMvcLinkBuilder.linkTo(CategoriaResource.class).slash(categoria.
	 * getId()).withSelfRel()); return objDto; }
	 **/
	
	/* TRANSFORMA EM DTO SEM RETORNAR LINK */
	/*
	 * public CategoriaDto toCategoriaDto(Categoria categoria) { return
	 * modelMapper.map(categoria, CategoriaDto.class); }
	 */

}
