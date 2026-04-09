package com.as.produtos.models;

import com.as.produtos.enums.ProdutoEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TBL_PRODUTO")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    @Enumerated(EnumType.STRING)
    private ProdutoEnum produtoEnum;
}
