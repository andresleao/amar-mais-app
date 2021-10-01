package com.acc.amar.mais.mapper;

import com.acc.amar.mais.dtos.UsuarioDto;
import com.acc.amar.mais.models.Usuario;

public class UsuarioMapper {
    public static UsuarioDto toDTO(Usuario entity){
        UsuarioDto dto = new UsuarioDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setCpf(entity.getCpf());
        dto.setEmail(entity.getEmail());
        dto.setInscricao(entity.getInscricao());
        dto.setTelefone(entity.getTelefone());
        dto.setBairro(entity.getBairro());
        dto.setCidade(entity.getCidade());
        return dto;
    }

    public static Usuario toEntity(UsuarioDto dto){
        Usuario entity = new Usuario();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setCpf(dto.getCpf());
        entity.setEmail(dto.getEmail());
        entity.setInscricao(dto.getInscricao());
        entity.setTelefone(dto.getTelefone());
        entity.setBairro(dto.getBairro());
        entity.setCidade(dto.getCidade());
        return entity;
    }
}
