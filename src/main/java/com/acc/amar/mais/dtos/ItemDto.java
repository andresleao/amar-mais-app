package com.acc.amar.mais.dtos;
import java.sql.Blob;

public class ItemDto {

    private Integer id;
    private String nome;
    private String descricao;
    private String classificacao;
    private Blob foto;
    private Boolean isAtivo;
    private Integer idDoacao;

    public ItemDto(){}

    public ItemDto(Integer id, String nome, String descricao, String classificacao, Blob foto, Boolean isAtivo, Integer idDoacao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.classificacao = classificacao;
        this.foto = foto;
        this.isAtivo = isAtivo;
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
        return isAtivo;
    }

    public void setAtivo(Boolean ativo) {
        isAtivo = ativo;
    }

    public Integer getIdDoacao() {
        return idDoacao;
    }

    public void setIdDoacao(Integer idDoacao) {
        this.idDoacao = idDoacao;
    }
}
