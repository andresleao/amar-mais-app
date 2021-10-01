package com.acc.amar.mais.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Doacao {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private boolean isAtivo;
    
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private Integer IdUsuarioDoador;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doacao")
    private List<Item> itens;

    public Doacao(){}
    
    public Doacao(Integer id, LocalDateTime dataCriacao, Usuario usuario, Integer idUsuarioDoador) {
        this.id = id;
        this.isAtivo = true;
        this.dataCriacao = dataCriacao;
        this.usuario = usuario;
        IdUsuarioDoador = idUsuarioDoador;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
  
	public boolean isAtivo() {
		return isAtivo;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getIdUsuarioDoador() {
        return IdUsuarioDoador;
    }

    public void setIdUsuarioDoador(Integer idUsuarioDoador) {
        IdUsuarioDoador = idUsuarioDoador;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
