package com.acc.amar.mais.dtos;
import com.acc.amar.mais.models.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDateTime;
import java.util.List;

public class DoacaoDto {
    private int id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCriacao;

    @JsonProperty("usuario")
    private UsuarioDto usuarioDto;

    private Integer IdUsuarioDoador;
    private List<ItemDto> itens;

    public DoacaoDto(){}

    public DoacaoDto(int id, LocalDateTime dataCriacao, UsuarioDto usuarioDto, Integer idUsuarioDoador) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.usuarioDto = usuarioDto;
        IdUsuarioDoador = idUsuarioDoador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setUsuarioDto(UsuarioDto usuarioDto) {
        this.usuarioDto = usuarioDto;
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