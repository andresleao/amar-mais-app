package com.acc.amar.mais.models;
import javax.persistence.*;
import java.sql.Blob;

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

    public Item(){}

    public Item(Integer id, String nome, String descricao, String classificacao, Blob foto, Boolean isAtivo, Doacao doacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.classificacao = classificacao;
        this.foto = foto;
        this.isAtivo = isAtivo;
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

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public Boolean getAtivo() {
        return isAtivo;
    }

    public void setAtivo(Boolean ativo) {
        isAtivo = ativo;
    }

    public Doacao getDoacao() {
        return doacao;
    }

    public void setDoacao(Doacao doacao) {
        this.doacao = doacao;
    }
}
