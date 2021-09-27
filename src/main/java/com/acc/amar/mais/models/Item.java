package com.acc.amar.mais.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private String classificacao;
    private Blob foto;
    private Boolean isAtivo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doacao_id")
    private Doacao doacao;
}
