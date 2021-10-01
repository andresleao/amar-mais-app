package com.acc.amar.mais.models;
import com.acc.amar.mais.models.enuns.ClassificacaoEnum;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private Integer classificacao;
    private Blob foto;
  
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doacao_id")
    private Doacao doacao;

    public Item(){}

   
    public Item(Integer id, String nome, String descricao, ClassificacaoEnum classificacao, Blob foto, Doacao doacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.classificacao = (classificacao == null) ? null : classificacao.getId();
        this.foto = foto;
        this.doacao = doacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Integer classificacao) {
        this.classificacao = classificacao;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public Doacao getDoacao() {
        return doacao;
    }
    

    public void setDoacao(Doacao doacao) {
        this.doacao = doacao;
    }
}