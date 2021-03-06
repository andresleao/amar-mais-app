package com.acc.amar.mais.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public class DoacaoNewDto {
    
	private int id;
    
	private boolean isAtivo;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCriacao;
    
	@JsonProperty("usuario")
    private UsuarioDto usuario;
    
    private Integer IdUsuarioDoador;
    private List<ItemNewDTO> itens;

    public DoacaoNewDto(){
    }

    public DoacaoNewDto(int id, boolean isAtivo, LocalDateTime dataCriacao, UsuarioDto usuario, Integer idUsuarioDoador) {
        this.id = id;
        this.isAtivo = isAtivo;
        this.dataCriacao = dataCriacao;
        this.usuario = usuario;
        IdUsuarioDoador = idUsuarioDoador;
    }

    //usuario
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
	public boolean isAtivo() {
		return isAtivo;
	}

	public void setAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDto usuario) {
		this.usuario = usuario;
	}

	public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public UsuarioDto getUsuarioDto() {
        return usuario;
    }

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuario = usuarioDto;
    }

    public Integer getIdUsuarioDoador() {
        return IdUsuarioDoador;
    }

    public void setIdUsuarioDoador(Integer idUsuarioDoador) {
        IdUsuarioDoador = idUsuarioDoador;
    }

    public List<ItemNewDTO> getItens() {
        return itens;
    }

    public void setItens(List<ItemNewDTO> itens) {
        this.itens = itens;
    }
}
