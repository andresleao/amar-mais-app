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

        return dto;
    }
}
