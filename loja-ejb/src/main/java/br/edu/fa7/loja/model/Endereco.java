package br.edu.fa7.loja.model;

import java.io.Serializable;

import javax.persistence.ManyToOne;

public class Endereco implements Serializable{

	private static final long serialVersionUID = -4335416492270530527L;

	private Long id;
	
	private String logradouro;
	
	private String complemento;
	
	private String cep;
	
	@ManyToOne
	private Cliente cliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
