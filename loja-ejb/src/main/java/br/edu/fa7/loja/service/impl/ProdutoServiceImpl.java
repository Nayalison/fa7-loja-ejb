package br.edu.fa7.loja.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.edu.fa7.loja.model.Produto;
import br.edu.fa7.loja.service.ProdutoService;

@Stateless(name="ProdutoService")
public class ProdutoServiceImpl implements ProdutoService {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> findAll() {
		return entityManager.createQuery("from Produto").getResultList();
	}

	@Override
	public Produto find(Long id) {
		return entityManager.find(Produto.class, id);
	}

	@Override
	public void save(Produto produto) {
		entityManager.persist(produto);
	}

	@Override
	public void update(Long id, Produto produto) {
		produto.setId(id);
		entityManager.merge(produto);
	}

	@Override
	public void delete(Long id) {
		Produto produto = find(id);
		entityManager.remove(produto);
	}

}
