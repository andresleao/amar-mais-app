package com.acc.amar.mais.mapper;

import com.acc.amar.mais.dtos.DoacaoDto;
import com.acc.amar.mais.dtos.DoacaoNewDto;
import com.acc.amar.mais.models.Doacao;

import java.util.ArrayList;
import java.util.List;

public class DoacaoMapper {

    public static Doacao toEntity(DoacaoDto dto){
      Doacao entity = new Doacao();
      entity.setId(dto.getId());
      dto.setAtivo(true);
      entity.setAtivo(dto.isAtivo());
      entity.setDataCriacao(dto.getDataCriacao());
      entity.setItens(ItemMapper.toListEntity(dto.getItens()));
      entity.setIdUsuarioDoador(dto.getIdUsuarioDoador());
      entity.setUsuario(UsuarioMapper.toEntity(dto.getUsuarioDto()));
      return entity;
    }
    public static Doacao toEntity(DoacaoNewDto dto){
        Doacao entity = new Doacao();
        entity.setId(dto.getId());
        dto.setAtivo(true);
        entity.setAtivo(dto.isAtivo());
        entity.setDataCriacao(dto.getDataCriacao());
        entity.setItens(ItemMapper.listItemNewtoListEntity(dto.getItens()));
        entity.setIdUsuarioDoador(dto.getIdUsuarioDoador());
        entity.setUsuario(UsuarioMapper.toEntity(dto.getUsuarioDto()));
        return entity;
    }

    public static DoacaoDto toDTO(Doacao entity){
        DoacaoDto dto = new DoacaoDto();
        dto.setId(entity.getId());
        entity.setAtivo(true);
        dto.setAtivo(entity.isAtivo());
        dto.setItens(ItemMapper.toListDTO(entity.getItens()));
        dto.setIdUsuarioDoador(entity.getIdUsuarioDoador());
        dto.setDataCriacao(entity.getDataCriacao());
        dto.setUsuarioDto(UsuarioMapper.toDTO(entity.getUsuario()));
        return dto;
    }

    public static List<DoacaoDto> toDtoList(List<Doacao> doacaoList){
        List<DoacaoDto> doacaoDtoList = new ArrayList<>();
        doacaoList.forEach(entity ->{
            DoacaoDto dto = new DoacaoDto();
            dto.setId(entity.getId());
            entity.setAtivo(true);
            dto.setAtivo(entity.isAtivo());
            dto.setDataCriacao(entity.getDataCriacao());
            dto.setIdUsuarioDoador(entity.getIdUsuarioDoador());
            dto.setUsuarioDto(UsuarioMapper.toDTO(entity.getUsuario()));
            dto.setItens(ItemMapper.toListDTO(entity.getItens()));

            doacaoDtoList.add(dto);
        });
        return doacaoDtoList;
    }

}
