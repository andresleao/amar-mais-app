package com.acc.amar.mais.controllers;

import com.acc.amar.mais.dtos.DoacaoDto;
import com.acc.amar.mais.mapper.DoacaoMapper;
import com.acc.amar.mais.models.Doacao;
import com.acc.amar.mais.services.DoacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/doacao")
public class DoacaoController {

    @Autowired
    private DoacaoService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@Valid @RequestBody DoacaoDto dto){
        Doacao doacao = service.create(DoacaoMapper.toEntity(dto));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(doacao.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<DoacaoDto> findById(@PathVariable Integer id){
        DoacaoDto doacaoDto = DoacaoMapper.toDTO(service.findById(id));
        return ResponseEntity.ok().body(doacaoDto);
    }
}
