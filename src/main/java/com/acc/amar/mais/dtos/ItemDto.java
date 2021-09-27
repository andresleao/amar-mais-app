package com.acc.amar.mais.dtos;

import com.acc.amar.mais.models.Doacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Blob;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private Integer id;
    private String nome;
    private String descricao;
    private String classificacao;
    private Blob foto;
    private Boolean isAtivo;
    private Integer idDoacao;
}
