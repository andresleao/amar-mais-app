package com.acc.amar.mais.services;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.acc.amar.mais.dtos.UsuarioDto;
import com.acc.amar.mais.mapper.UsuarioMapper;
import com.acc.amar.mais.models.Doacao;
import com.acc.amar.mais.models.Item;
import com.acc.amar.mais.models.enuns.ClassificacaoEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.acc.amar.mais.models.Login;
import com.acc.amar.mais.models.Usuario;
import com.acc.amar.mais.repositories.ItemRepository;
import com.acc.amar.mais.repositories.LoginRepository;
import com.acc.amar.mais.repositories.UsuarioRepository;

@Service
public class DBService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    LoginService loginService;
    @Autowired
    DoacaoService doacaoService;
    @Autowired
    ItemRepository itemRepository;

    public void instanciaDB() {

        UsuarioDto usuarioDTO1 = new UsuarioDto();
        usuarioDTO1.setNome("Antony");
        usuarioDTO1.setSobrenome("Maia");
        usuarioDTO1.setCpf("105.204.720-39");
        usuarioDTO1.setCidade("Recife");
        usuarioDTO1.setBairro("Boa Viagem");
        usuarioDTO1.setTelefone("(81)988334455");
        usuarioDTO1.setEmail("antonymaia@gmail.com");
        usuarioDTO1.setSenha("1234");
        Usuario usuario1 = usuarioService.create(usuarioDTO1);

        UsuarioDto usuarioDTO2 = new UsuarioDto();
        usuarioDTO2.setNome("Diego");
        usuarioDTO2.setSobrenome("Cravo");
        usuarioDTO2.setCpf("514.177.880-03");
        usuarioDTO2.setCidade("Recife");
        usuarioDTO2.setBairro("Jaqueira");
        usuarioDTO2.setTelefone("(81)988334455");
        usuarioDTO2.setEmail("diegocravo@gmail.com");
        usuarioDTO2.setSenha("1234");
        Usuario usuario2 = usuarioService.create(usuarioDTO2);

        UsuarioDto usuarioDTO3 = new UsuarioDto();
        usuarioDTO3.setNome("Émerson");
        usuarioDTO3.setSobrenome("Parker");
        usuarioDTO3.setCpf("836.734.370-03");
        usuarioDTO3.setCidade("Recife");
        usuarioDTO3.setBairro("Casa Amarela");
        usuarioDTO3.setTelefone("(81)988334455");
        usuarioDTO3.setEmail("emersonparker@gmail.com");
        usuarioDTO3.setSenha("1234");
        Usuario usuario3 = usuarioService.create(usuarioDTO3);

        UsuarioDto usuarioDTO4 = new UsuarioDto();
        usuarioDTO4.setNome("André");
        usuarioDTO4.setSobrenome("Leão");
        usuarioDTO4.setCpf("132.738.240-77");
        usuarioDTO4.setCidade("Recife");
        usuarioDTO4.setBairro("Madalena");
        usuarioDTO4.setTelefone("(81)988334455");
        usuarioDTO4.setEmail("andreleao@gmail.com");
        usuarioDTO4.setSenha("1234");
        Usuario usuario4 = usuarioService.create(usuarioDTO4);

        UsuarioDto usuarioDTO5 = new UsuarioDto();
        usuarioDTO5.setNome("Júnior");
        usuarioDTO5.setSobrenome("Nascimento");
        usuarioDTO5.setCpf("031.303.040-53");
        usuarioDTO5.setCidade("Recife");
        usuarioDTO5.setBairro("Espinheiro");
        usuarioDTO5.setTelefone("(81)988334455");
        usuarioDTO5.setEmail("juniornascimento@gmail.com");
        usuarioDTO5.setSenha("1234");
        Usuario usuario5 = usuarioService.create(usuarioDTO5);

        UsuarioDto usuarioDTO6 = new UsuarioDto();
        usuarioDTO6.setNome("Marcos");
        usuarioDTO6.setSobrenome("Santos");
        usuarioDTO6.setCpf("863.478.300-60");
        usuarioDTO6.setCidade("Recife");
        usuarioDTO6.setBairro("Espinheiro");
        usuarioDTO6.setTelefone("(81)988334455");
        usuarioDTO6.setEmail("marcossantos@gmail.com");
        usuarioDTO6.setSenha("1234");
        Usuario usuario6 = usuarioService.create(usuarioDTO6);

    }
}
