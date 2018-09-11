package com.produtos.apiRest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apiRest.repository.ProdutoRepository;
import com.produtos.apiRest.models.Produto;

@RestController
//Definindo a URL 
@RequestMapping(value="/api")
public class ProdutoResource {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	//Method:GET url/api/produtos
	@GetMapping("/produtos")
	public List<Produto> listaProdutos() {
		return produtoRepository.findAll();
	}
	
	//Method:GET url/api/produtos/:id
	@GetMapping("/produtos/{id}")
	public Produto listaProduto(@PathVariable(value="id") long id) {
		//Função criada dentro de main/java -> apiRest.repository
		return produtoRepository.findById(id);
	}
	
	//Method:POST url/api/produtos
	@PostMapping("/produtos")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	//Method:DELETE url/api/produtos
	@DeleteMapping("/produtos")
	public void deleteProduto(@RequestBody Produto produto) {
		produtoRepository.delete(produto);
	}
	
	//Method:PUT url/api/produtos
	@PutMapping("/produtos")
	public Produto atualizaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
