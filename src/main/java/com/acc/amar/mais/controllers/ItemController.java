package com.acc.amar.mais.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.acc.amar.mais.dtos.ItemDto;
import com.acc.amar.mais.dtos.ItemNewDTO;
import com.acc.amar.mais.mapper.ItemMapper;
import com.acc.amar.mais.models.Item;
import com.acc.amar.mais.services.ItemService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private ItemService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@Valid @RequestBody ItemDto dto){
        Item item = service.create(ItemMapper.toEntity(dto));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(item.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
    
    @GetMapping(value = "/{id}")
	public ResponseEntity<ItemNewDTO> findById(@PathVariable Integer id) {
		Item item = service.findById(id);
		
		ItemNewDTO dto = new ItemNewDTO();
		dto.setId(item.getId());
		dto.setClassificacao(item.getClassificacao());
		dto.setFoto(dto.getFoto());
		dto.setNome(item.getNome());
		
		return ResponseEntity.ok().body(dto);
	}
    
    
}
