package com.bno.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bno.bookstore.domain.Categoria;
import com.bno.bookstore.domain.Livro;
import com.bno.bookstore.repositories.CategoriaRepository;
import com.bno.bookstore.repositories.LivroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instaciaBaseDedados() {
		Categoria cat1 = new Categoria(null, "Informatica", "Livro de TI");
		Categoria cat2 = new Categoria(null, "Pesca", "Livro de Pesca");
		Categoria cat3 = new Categoria(null, "Culinaria", "Livro de Culinaria");

		Livro l1 = new Livro(null, "Clean Code", "Robert", "bla", cat1);
		Livro l2 = new Livro(null, "The Code", "Francisco", "blu", cat1);
		Livro l3 = new Livro(null, "The pesca", "Joao", "bli", cat2);
		Livro l4 = new Livro(null, "Auto Mar", "Rob", "blap", cat2);
		Livro l5 = new Livro(null, "Comer", "Canja", "blap", cat3);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4));
		cat3.getLivros().addAll(Arrays.asList(l5));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
	}

}
