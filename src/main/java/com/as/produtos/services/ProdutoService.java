package com.as.produtos.services;

import com.as.produtos.models.ProdutoModel;
import com.as.produtos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel criar(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> listar() {
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produtoModel) {
        ProdutoModel produto = produtoRepository.findById(id).get();
        produto.setId(produtoModel.getId());
        produto.setNome(produtoModel.getNome());
        produto.setDescricao(produtoModel.getDescricao());
        produto.setPreco(produtoModel.getPreco());
        produto.setProdutoEnum(produtoModel.getProdutoEnum());
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }
}
// PLOPV (CRUD)