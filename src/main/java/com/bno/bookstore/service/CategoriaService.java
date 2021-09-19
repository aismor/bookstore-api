package com.bno.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bno.bookstore.domain.Categoria;
import com.bno.bookstore.repositories.CategoriaRepository;
import com.bno.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repositopry;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repositopry.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado Id: " + id + ", tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return repositopry.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repositopry.save(obj);
	}
}
