package br.edu.fa7.loja.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.edu.fa7.loja.model.Compra;
import br.edu.fa7.loja.model.Produto;
import br.edu.fa7.loja.service.CompraService;
import br.edu.fa7.loja.service.ProdutoService;

@Path("/compras")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CompraResources {
	
	@Inject
	private CompraService service;
	
	@Inject
	private ProdutoService produtoService;
	
	@GET
	public List<Compra> findAll() {
		return service.findAll();
	}
	
	@GET
	@Path("{id}")
	public Response find(@PathParam("id") Long id) {
		Compra compra = service.find(id);
		if (compra != null) {
			return Response.ok(compra).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@POST
	public Response save(Compra compra) {
		Produto produto = produtoService.find(compra.getProduto().getId());
		if (produto != null) {
			compra.setProduto(produto);
			service.save(compra);
			return Response.ok().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@PUT
	@Path("{id}")
	public Response update(@PathParam ("id") Long id, Compra compra) {
		Produto produto = produtoService.find(compra.getProduto().getId());
		if (produto != null) {
			compra.setProduto(produto);
			service.update(id, compra);
			return Response.ok().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam ("id") Long id){
		Compra compra = service.find(id);
		if(compra != null) {
			service.delete(id);
			return Response.ok().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
