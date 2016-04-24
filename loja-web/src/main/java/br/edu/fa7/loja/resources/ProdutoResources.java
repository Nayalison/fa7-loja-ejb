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

import br.edu.fa7.loja.model.Produto;
import br.edu.fa7.loja.service.ProdutoService;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResources {
	
	@Inject
	private ProdutoService service;
	
	@GET
	public List<Produto> findAll() {
		return service.findAll();
	}
	
	@GET
	@Path("{id}")
	public Response find(@PathParam("id") Long id) {
		Produto produto = service.find(id);
		if (produto != null) {
			return Response.ok(produto).build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}

	@POST
	public Response save(Produto produto) {
		service.save(produto);
		return Response.ok().build();
	}
	
	@PUT
	@Path("{id}")
	public Response update(@PathParam ("id") Long id, Produto produto) {
		service.update(id, produto);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam ("id") Long id){
		Produto produto = service.find(id);
		if(produto != null) {
			service.delete(id);
			return Response.ok().build();
		} else {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
