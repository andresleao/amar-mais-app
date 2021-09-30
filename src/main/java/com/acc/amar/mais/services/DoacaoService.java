package com.acc.amar.mais.services;

import com.acc.amar.mais.models.Doacao;
import com.acc.amar.mais.models.Item;
import com.acc.amar.mais.repositories.DoacaoRepository;
import com.acc.amar.mais.repositories.ItemRepository;
import com.acc.amar.mais.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DoacaoService {

    @Autowired
    private DoacaoRepository repository;
    @Autowired
    private ItemRepository itemRepository;

    public Doacao create(Doacao doacao) {
        List<Item> itens = doacao.getItens();
        doacao.setItens(null);
        doacao = repository.save(doacao);
        doacao.setDataCriacao(LocalDateTime.now());
        for(Item item : itens){
            item.setDoacao(doacao);
        }
        itemRepository.saveAll(itens);
        return doacao;
    }

    public Doacao findById(Integer id) {
        Optional<Doacao> optionalDoacao = repository.findById(id);
        return optionalDoacao.orElseThrow(() -> new ObjectNotFoundException("Doacao não encontrada"));
    }

   public List<Doacao> findByCategoria(String categoria) {
        Optional<List<Doacao>> optionalDoacaos = repository.findByCategoria(categoria);
        return optionalDoacaos.orElseThrow(() -> new ObjectNotFoundException("Doação não encontrada"));
    }
}
