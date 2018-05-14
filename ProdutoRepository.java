package br.edu.br.projeto.repository;

import org.springframework.data.repository.CrudRepository;

import br.edu.up.jpa.dominio.Produto;


public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
