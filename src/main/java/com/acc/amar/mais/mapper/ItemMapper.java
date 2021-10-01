package com.acc.amar.mais.mapper;

import java.util.ArrayList;
import java.util.List;

import com.acc.amar.mais.dtos.ItemDto;
import com.acc.amar.mais.dtos.ItemNewDTO;
import com.acc.amar.mais.models.Doacao;
import com.acc.amar.mais.models.Item;
import com.acc.amar.mais.models.enuns.ClassificacaoEnum;

public class ItemMapper {

    public static Item toEntity(ItemDto dto){
        Doacao doacao = new Doacao();
        doacao.setId(dto.getIdDoacao());
        Item item = new Item(
                dto.getId(),
                dto.getNome(),
                dto.getDescricao(),
                ClassificacaoEnum.toEnum(dto.getDescricao()),
                dto.getFoto(),
                //dto.getAtivo(),
                doacao
        );
        return item;
    }

    public static ItemDto toDTO(Item entity){
        ItemDto dto = new ItemDto(
                entity.getId(),
                entity.getNome(),
                entity.getDescricao(),
                ClassificacaoEnum.toEnum(entity.getClassificacao()),
                entity.getFoto(),
                //entity.getAtivo(),
                entity.getDoacao().getId()
        );
        return dto;
    }

    public static List<ItemDto> toListDTO(List<Item> listEntity){
        List<ItemDto> listDTO = new ArrayList<>();
        listEntity.forEach(entity -> {
            ItemDto dto = new ItemDto(
                    entity.getId(),
                    entity.getNome(),
                    entity.getDescricao(),
                    ClassificacaoEnum.toEnum(entity.getClassificacao()),
                    entity.getFoto(),
                    //entity.getAtivo(),
                    entity.getDoacao().getId()
            );
            listDTO.add(dto);
        });
        return listDTO;
    }

    public static List<Item> toListEntity(List<ItemDto> listDto){
        if(listDto != null) {
            List<Item> listEntity = new ArrayList<>();
            listDto.forEach(dto -> {
                Doacao doacao = new Doacao();
                if(dto.getIdDoacao() != null){
                    doacao.setId(dto.getIdDoacao());
                }
                Item item = new Item(
                        dto.getId(),
                        dto.getNome(),
                        dto.getDescricao(),
                        ClassificacaoEnum.toEnum(dto.getClassificacao()),
                        dto.getFoto(),
                        //dto.getAtivo(),
                        doacao
                );
                listEntity.add(item);
            });
            return listEntity;
        }
        return null;
    }

    public static List<Item> listItemNewtoListEntity(List<ItemNewDTO> listDto){
        if(listDto != null) {
            List<Item> listEntity = new ArrayList<>();
            listDto.forEach(dto -> {
                Doacao doacao = new Doacao();
                if(dto.getIdDoacao() != null){
                    doacao.setId(dto.getIdDoacao());
                }
                Item item = new Item(
                        dto.getId(),
                        dto.getNome(),
                        dto.getDescricao(),
                        ClassificacaoEnum.toEnum(dto.getClassificacao()),
                        dto.getFoto(),
                        //dto.getAtivo(),
                        doacao
                );
                listEntity.add(item);
            });
            return listEntity;
        }
        return null;
    }
}