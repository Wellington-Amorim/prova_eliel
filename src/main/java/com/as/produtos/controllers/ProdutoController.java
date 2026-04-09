package com.as.produtos.controllers;

import com.as.produtos.models.ProdutoModel;
import com.as.produtos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> criar(ProdutoModel produtoModel){
        ProdutoModel produto = produtoService.criar(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").build()
                .toUri();
        return ResponseEntity.created(uri).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listar(){
        List<ProdutoModel> produtos = produtoService.listar();
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> buscarPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizar(@PathVariable Long id, @RequestBody ProdutoModel produtoModel){
        ProdutoModel produto = produtoService.atualizar(id, produtoModel);
        return produto;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
// RROPR (CRUD)
