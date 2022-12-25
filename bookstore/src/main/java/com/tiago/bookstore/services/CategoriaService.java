package com.tiago.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiago.bookstore.domain.Categoria;
import com.tiago.bookstore.dto.CategoriaDto;
import com.tiago.bookstore.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElse(null);
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

}
