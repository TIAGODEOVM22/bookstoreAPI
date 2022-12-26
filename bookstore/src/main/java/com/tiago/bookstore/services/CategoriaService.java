package com.tiago.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.bookstore.domain.Categoria;
import com.tiago.bookstore.repository.CategoriaRepository;
import com.tiago.bookstore.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	/*TEM QUE TESTAR*/
	/*public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		obj = categoriaAssembler.toCategoriaDto(Categoria.class, CategoriaDto.class);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado id: " + id + ", tipo: " + Categoria.class.getName()));
	}*/
	
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException
				("Objeto não encontrado id: " + id + ", tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
}
