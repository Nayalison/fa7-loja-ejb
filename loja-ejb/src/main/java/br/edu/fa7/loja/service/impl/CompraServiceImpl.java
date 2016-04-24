package br.edu.fa7.loja.service.impl;

import java.util.List;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import br.edu.fa7.loja.model.Cliente;
import br.edu.fa7.loja.model.Compra;
import br.edu.fa7.loja.service.CompraService;
import br.edu.fa7.loja.util.GsonMapper;

@Stateless(name="CompraService")
public class CompraServiceImpl implements CompraService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Compra> findAll() {
		List<Compra> compras = entityManager.createQuery("from Compra").getResultList();
		for(Compra compra : compras) {
			carregarCliente(compra);
		}
		return compras;
	}

	@Asynchronous
	public void carregarCliente(Compra compra) {
		Unirest.setObjectMapper(new GsonMapper());
		try {
			String url = String.format("http://localhost:8082/clientes/%s", compra.getClienteId());
			HttpResponse<Cliente> bookResponse = Unirest.get(url).asObject(Cliente.class);
			Cliente cliente = bookResponse.getBody();
			compra.setCliente(cliente);
		} catch (UnirestException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Compra find(Long id) {
		Compra compra = entityManager.find(Compra.class, id);
		carregarCliente(compra);
		return compra;
	}

	@Override
	public void save(Compra compra) {
		entityManager.persist(compra);
	}

	@Override
	public void update(Long id, Compra compra) {
		compra.setId(id);
		entityManager.merge(compra);
	}

	@Override
	public void delete(Long id) {
		Compra compra = find(id);
		entityManager.remove(compra);
	}

}
