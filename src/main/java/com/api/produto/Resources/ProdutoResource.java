package com.api.produto.Resources;

import com.api.produto.models.Produto;
import com.api.produto.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Produtos")
@CrossOrigin(origins = "*") //liberar todos os dominios de acessar a api.
public class ProdutoResource {

    @Autowired
    ProdutoRepository produtoRepository;

    //METODO GET

    @GetMapping("/produtos")
    @ApiOperation(value = "Retorna todos os produtos")
    public List<Produto> listaProdutos() {
        return produtoRepository.findAll();
    }

    @GetMapping("/produto/{id}")
    @ApiOperation(value = "Retorna um id de um produto")
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);

    }

    //METODO POST

    @PostMapping("/produto")
    @ApiOperation(value = "salva o produto")
    public Produto salvaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    //METODO DELETE

    @DeleteMapping("/produto")
    @ApiOperation(value = "Deleta o produto")
    public void deletaProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto); //sem retorno, apenas excute.
    }

    //METODO PUT -- ATUALIZAR

    @PutMapping("/produto")
    @ApiOperation(value = "atualiza o produto")
    public Produto atualizaProduto(@RequestBody Produto produto) {
    return produtoRepository.save(produto);    }
}
