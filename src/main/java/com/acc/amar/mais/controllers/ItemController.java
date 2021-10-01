package com.acc.amar.mais.controllers;

import com.acc.amar.mais.dtos.ItemDto;
import com.acc.amar.mais.mapper.ItemMapper;
import com.acc.amar.mais.models.Item;
import com.acc.amar.mais.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
}
