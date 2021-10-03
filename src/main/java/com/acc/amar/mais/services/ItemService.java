package com.acc.amar.mais.services;

import com.acc.amar.mais.models.Item;
import com.acc.amar.mais.repositories.ItemRepository;
import com.acc.amar.mais.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Item create(Item item) {
        Item itemCriado = repository.save(item);
        return itemCriado;
    }
    public Item update(Item item){
        Item oldItem = findById(item.getId());
        oldItem.setNome(item.getNome());
        oldItem.setDescricao(item.getDescricao());
        oldItem.setClassificacao(item.getClassificacao());
        oldItem.setFoto(item.getFoto());
        repository.save(oldItem);
        return oldItem;
    }
    public Item findById(Integer id) {
		Optional<Item> item = repository.findById(id);
		return item.orElseThrow(
				() -> new ObjectNotFoundException("Item não encontrado! Id: " + id));
	}
}
