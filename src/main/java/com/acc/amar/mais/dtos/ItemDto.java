package com.acc.amar.mais.dtos;
import com.acc.amar.mais.models.enuns.ClassificacaoEnum;

import java.sql.Blob;

public class ItemDto {

    private Integer id;
    private String nome;
    private String descricao;
    private String classificacao;
    private Blob foto;
    private Boolean ativo;
    private Integer idDoacao;

    public ItemDto(){}

    public ItemDto(Integer id, String nome, String descricao, ClassificacaoEnum classificacao, Blob foto, Boolean isAtivo, Integer idDoacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.classificacao = classificacao.getString();
        this.foto = foto;
        this.ativo = true;
        this.idDoacao = idDoacao;
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
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Integer getIdDoacao() {
        return idDoacao;
    }

    public void setIdDoacao(Integer idDoacao) {
        this.idDoacao = idDoacao;
    }
}
