package com.acc.amar.mais.dtos;

import com.acc.amar.mais.models.Item;
import com.acc.amar.mais.models.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoacaoDto {
    private int id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataCriacao;
    private Usuario usuario;
    private Integer IdUsuarioDoador;
    private List<ItemDto> itens;
}