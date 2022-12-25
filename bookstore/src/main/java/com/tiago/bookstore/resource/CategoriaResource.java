package com.tiago.bookstore.resource;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiago.bookstore.assembler.CategoriaAssembler;
import com.tiago.bookstore.dto.CategoriaDto;
import com.tiago.bookstore.repository.CategoriaRepository;
import com.tiago.bookstore.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private CategoriaAssembler categoriaAssembler;

	@GetMapping(value = "/{categoriaId}")
	public ResponseEntity<CategoriaDto> findByIdDTO(@PathVariable Integer categoriaId) {
		return categoriaRepository.findById(categoriaId)
				.map(categoria -> ResponseEntity.ok(categoriaAssembler.toCategoriaDto(categoria)))
				.orElse(ResponseEntity.notFound().build());

	}
	
	@GetMapping
	public List<CategoriaDto> findAll(){
		return categoriaAssembler.toListCategoriaDto(categoriaRepository.findAll());
	}
	

	/*@GetMapping
	public List<CategoriaDto> findll() {
		return categoriaRepository.findAll().stream()
				.map(this::toCategoriaDto).collect(Collectors.toList());
	}*/

	/*private CategoriaDto toCategoriaDto(Categoria categoria) {
		return modelMapper.map(categoria, CategoriaDto.class);
	}*/

}
