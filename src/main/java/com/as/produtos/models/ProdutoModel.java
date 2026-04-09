package com.as.produtos.models;

import com.as.produtos.enums.ProdutoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TBL_PRODUTO")
public class ProdutoModel {
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private ProdutoEnum produtoEnum;
}
