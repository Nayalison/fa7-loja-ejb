package br.edu.fa7.loja.service;

import java.util.List;

import javax.ejb.Local;

import br.edu.fa7.loja.model.Produto;

@Local
public interface ProdutoService {
	
	public List<Produto> findAll();

	public Produto find(Long id);

	public void save(Produto produto);

	public void update(Long id, Produto produto);

	public void delete(Long id);

}
