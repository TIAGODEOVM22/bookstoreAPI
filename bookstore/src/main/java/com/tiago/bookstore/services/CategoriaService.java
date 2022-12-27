package com.tiago.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tiago.bookstore.domain.Categoria;
import com.tiago.bookstore.dto.CategoriaDto;
import com.tiago.bookstore.repository.CategoriaRepository;
import com.tiago.bookstore.services.exception.DataIntegrityVaiolationException;
import com.tiago.bookstore.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public Categoria findById(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException
				("Objeto não encontrado! ID: " + id + ", tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}
	
	public Categoria create(Categoria obj) {
		obj.setId(null); /*id NULL p/ o usuario não informar um ID e o JPA atualizar um Obj já existente*/
		return categoriaRepository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDto objDTO) {
		Categoria obj = findById(id);/*Antes de Atualizar Verifica se ID existe*/
		obj.setNome(objDTO.getNome());
		obj.setDescricao(objDTO.getDescricao());
		return categoriaRepository.save(obj);
	}
	
	public void deletar(Integer id) {
		findById(id);//Antes de Deletar Verifica se ID existe
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e)/*do pacote do spring*/ {
			throw new DataIntegrityVaiolationException("Categoria não pode ser DELETADA, possui Livros associados!");
		}
		
		
	}
	
	
	/*METODO DELETA APENAS CATEGORIA SEM LIVROS*/
	/*public void deletar(Integer id) {
		findById(id);Antes de Deletar Verifica se ID existe
		categoriaRepository.deleteById(id);
	}*/
}
