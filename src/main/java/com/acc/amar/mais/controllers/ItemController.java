package com.acc.amar.mais.controllers;

import com.acc.amar.mais.dtos.ItemDto;
import com.acc.amar.mais.dtos.ItemNewDTO;
import com.acc.amar.mais.mapper.ItemMapper;
import com.acc.amar.mais.models.Item;
import com.acc.amar.mais.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ItemNewDTO dto){
        Item item = ItemMapper.toEntity(dto);
        ItemDto responseDto = ItemMapper.toDTO(service.update(item));
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(responseDto.getId())
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
