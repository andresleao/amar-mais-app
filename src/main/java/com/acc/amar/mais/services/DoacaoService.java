package com.acc.amar.mais.services;

import com.acc.amar.mais.models.Doacao;
import com.acc.amar.mais.models.Item;
import com.acc.amar.mais.models.Usuario;
import com.acc.amar.mais.repositories.DoacaoRepository;
import com.acc.amar.mais.repositories.ItemRepository;
import com.acc.amar.mais.services.exceptions.DataIntegratyViolationException;
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
    @Autowired
    private UsuarioService usuarioService;

    public Doacao create(Doacao doacao) {
        Usuario usuarioDoador = usuarioService.findById(doacao.getUsuario().getId());
        List<Item> itens = doacao.getItens();
        doacao.setItens(null);
        doacao.setAtivo(true);
        doacao.setDataCriacao(LocalDateTime.now());
        doacao = repository.save(doacao);
        for(Item item : itens){
            item.setDoacao(doacao);
        }
        itemRepository.saveAll(itens);
        return doacao;
    }

    public Doacao findById(Integer id) {
        Optional<Doacao> optionalDoacao = repository.findById(id);
        return optionalDoacao.orElseThrow(() -> new ObjectNotFoundException("Doacao não encontrada! Id: "+id));
    }

    public List<Doacao> findAll() {
        List<Doacao> doacaoList = repository.findAll();
        doacaoList.forEach(doacao -> {
            doacao.getUsuario().setCpf(null);
        });
        return doacaoList;
    }

    public List<Doacao> findAllByAtivo() {
        List<Doacao> doacaoList = repository.findAllByAtivo();
        return doacaoList;
    }

    public void disableDoacao(Integer idDoacao, Integer idDonatario) {
        Usuario usuarioDonatario = usuarioService.findById(idDonatario);
        Doacao doacao = findById(idDoacao);
        if(doacao.getUsuario().getId() == usuarioDonatario.getId()){
            throw new DataIntegratyViolationException("Usuário donatario não pode ser o usuário doador!");
        }
        repository.disableDoacao(idDoacao, idDonatario);
    }

    public List<Doacao> findaAllByDonor(Integer idDonor) {
        Usuario usuario = usuarioService.findById(idDonor);
        List<Doacao> doacaoList = repository.findAllByDonor(idDonor);
        return doacaoList;
    }
}
