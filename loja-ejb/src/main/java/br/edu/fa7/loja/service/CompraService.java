package br.edu.fa7.loja.service;

import java.util.List;

import javax.ejb.Local;

import br.edu.fa7.loja.model.Compra;

@Local
public interface CompraService {

	public List<Compra> findAll();

	public Compra find(Long id);

	public void save(Compra compra);

	public void update(Long id, Compra compra);

	public void delete(Long id);
}
