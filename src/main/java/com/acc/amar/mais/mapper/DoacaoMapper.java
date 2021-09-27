package com.acc.amar.mais.mapper;

import com.acc.amar.mais.dtos.DoacaoDto;
import com.acc.amar.mais.models.Doacao;
import com.acc.amar.mais.models.Item;

public class DoacaoMapper {
    public static Doacao toEntity(DoacaoDto dto){
      Doacao entity = new Doacao(
                dto.getId(),
                dto.getDataCriacao(),
                dto.getUsuario(),
                dto.getIdUsuarioDoador(),
              ItemMapper.toListEntity(dto.getItens())
        );
      return entity;
    }

    public static DoacaoDto toDTO(Doacao entity){
        DoacaoDto dto = new DoacaoDto(
                entity.getId(),
                entity.getDataCriacao(),
                entity.getUsuario(),
                entity.getIdUsuarioDoador(),
                ItemMapper.toListDTO(entity.getItens())
        );
        return dto;
    }

}
