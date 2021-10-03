package com.acc.amar.mais.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.amar.mais.models.Item;
import com.acc.amar.mais.repositories.ItemRepository;
import com.acc.amar.mais.services.exceptions.ObjectNotFoundException;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Item create(Item item) {
        Item itemCriado = repository.save(item);
        return itemCriado;
    }
    
    public Item findById(Integer id) {
		Optional<Item> item = repository.findById(id);
		return item.orElseThrow(
				() -> new ObjectNotFoundException("Item não encontrado! Id: " + id));
	}
}
