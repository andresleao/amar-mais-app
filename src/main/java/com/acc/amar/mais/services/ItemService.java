package com.acc.amar.mais.services;

import com.acc.amar.mais.models.Item;
import com.acc.amar.mais.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Item create(Item item) {
        Item itemCriado = repository.save(item);
        return itemCriado;
    }
}
