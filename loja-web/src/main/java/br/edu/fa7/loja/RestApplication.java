package br.edu.fa7.loja;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import br.edu.fa7.loja.resources.CompraResources;
import br.edu.fa7.loja.resources.ProdutoResources;

@ApplicationPath("/loja")
public class RestApplication extends Application {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Set<Class<?>> getClasses() {
		return new HashSet(Arrays.asList(ProdutoResources.class, CompraResources.class));
	}
}
