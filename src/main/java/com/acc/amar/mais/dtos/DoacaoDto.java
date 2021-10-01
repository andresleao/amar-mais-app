package com.acc.amar.mais.dtos;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DoacaoDto {
    private int id;
    private boolean isAtivo;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCriacao;
    private Integer IdUsuarioDoador;

    @JsonProperty("usuario")
    private UsuarioDto usuarioDto;
    private List<ItemDto> itens;

    public DoacaoDto(){}

    public DoacaoDto(int id, LocalDateTime dataCriacao, UsuarioDto usuario, Integer idUsuarioDoador) {
        this.id = id;
        this.isAtivo = true;
        this.dataCriacao = dataCriacao;
        this.usuarioDto = usuario;
        IdUsuarioDoador = idUsuarioDoador;
    }

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

	public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public UsuarioDto getUsuarioDto() {
        return usuarioDto;
    }

    public void setUsuarioDto(UsuarioDto usuario) {
        this.usuarioDto = usuario;
    }

    public Integer getIdUsuarioDoador() {
        return IdUsuarioDoador;
    }

    public void setIdUsuarioDoador(Integer idUsuarioDoador) {
        IdUsuarioDoador = idUsuarioDoador;
    }

    public List<ItemDto> getItens() {
        return itens;
    }

    public void setItens(List<ItemDto> itens) {
        this.itens = itens;
    }
}