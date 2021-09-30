package com.acc.amar.mais.mapper;

import com.acc.amar.mais.dtos.DoacaoDto;
import com.acc.amar.mais.models.Doacao;
import com.acc.amar.mais.models.Item;

import java.util.ArrayList;
import java.util.List;

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

    public static List<DoacaoDto> toDtoList(List<Doacao> doacaoList){
        List<DoacaoDto> doacaoDtoList = new ArrayList<>();
        doacaoList.forEach(entity ->{
            DoacaoDto dto = new DoacaoDto();
            dto.setId(entity.getId());
            dto.setDataCriacao(entity.getDataCriacao());
            dto.setIdUsuarioDoador(entity.getIdUsuarioDoador());
            dto.setUsuario(entity.getUsuario());
            dto.setItens(ItemMapper.toListDTO(entity.getItens()));

            doacaoDtoList.add(dto);
        });
        return doacaoDtoList;
    }

}
