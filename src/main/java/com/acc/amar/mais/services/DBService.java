package com.acc.amar.mais.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.acc.amar.mais.models.Login;
import com.acc.amar.mais.models.Usuario;
import com.acc.amar.mais.repositories.DoacaoRepository;
import com.acc.amar.mais.repositories.ItemRepository;
import com.acc.amar.mais.repositories.LoginRepository;
import com.acc.amar.mais.repositories.UsuarioRepository;

@Service
public class DBService {
 
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	DoacaoRepository doacaoRepository;
	
	@Autowired
	ItemRepository itemRepository;

	public void instanciaDB() {
		Usuario usuario1 = new Usuario(null, "André", "Souza Leão", "502.176.700-32", "andreleao@gmail.com", "Recife",
				"Espinheiro", "(81)98888-8811");
		Login login1 = new Login(null, "andreleao@gmail.com", encoder.encode("12345"), usuario1);
		
		Usuario usuario2 = new Usuario(null, "Diego", "Cravo", "514.177.880-03", "diegocravo@gmail.com", "Recife",
				"Boa Viagem", "(81)98877-7722");
		Login login2 = new Login(null, "diegocravo@gmail.com", encoder.encode("12345"), usuario2);
		
		Usuario usuario3 = new Usuario(null, "Émerson", "Parker", "836.734.370-03", "emersonparker@gmail.com", "Recife",
				"Casa Amarela", "(81)96687-8820");
		Login login3 = new Login(null, "emersonparker@gmail.com", encoder.encode("12345"), usuario3);
		
		Usuario usuario4 = new Usuario(null, "Antony", "Maia", "609.262.310-22", "antonymaia@gmail.com", "Recife",
				"Olinda", "(81)96986-3385");
		Login login4 = new Login(null, "antonymaia@gmail.com", encoder.encode("12345"), usuario4);
		
		Usuario usuario5 = new Usuario(null, "Júnior", "Nascimento", "031.303.040-53", "jrnascimento@gmail.com", "Recife",
				"Piedade", "(81)96986-3385");
		Login login5 = new Login(null, "jrnascimento@gmail.com", encoder.encode("12345"), usuario5);
		
		Usuario usuario6 = new Usuario(null, "Marcos", "Santos", "863.478.300-60", "marcossantoss@gmail.com", "Recife",
				"Candeias", "(81)94343-9365");
		Login login6 = new Login(null, "marcossantoss@gmail.com", encoder.encode("12345"), usuario6);
		
		/*
		Doacao doacao1 = new Doacao(null, LocalDateTime.now(), usuario1, null);
		Item item1 = new Item(null, "Cadeira de rodas", "Cinco anos de uso", ClassificacaoEnum.EQUIPAMENTO, null, doacao1);
		
		Doacao doacao2 = new Doacao(null, LocalDateTime.now(), usuario2, null);
		Item item2 = new Item(null, "Tubo de oxigênio", "Seminovo", ClassificacaoEnum.EQUIPAMENTO, null, doacao2);
		
		Doacao doacao3 = new Doacao(null, LocalDateTime.now(), usuario3, null);
		Item item3 = new Item(null, "Bengala ortopédica", "Bengala Dilepe Ajustável em Alumínio", ClassificacaoEnum.EQUIPAMENTO, null, doacao3);
		
		Doacao doacao4 = new Doacao(null, LocalDateTime.now(), usuario4, null);
		Item item4 = new Item(null, "Cama hospitalar ", "Cama Fawler com elevação", ClassificacaoEnum.MEDICACAO, null, doacao4);
		
		Doacao doacao5 = new Doacao(null, LocalDateTime.now(), usuario5, null);
		Item item5 = new Item(null, "Pírulas de corticóide ", "Válido até 04/10/2022", ClassificacaoEnum.MEDICACAO, null, doacao5);
		
		Doacao doacao6 = new Doacao(null, LocalDateTime.now(), usuario6, null);
		Item item6 = new Item(null, "Purificador de ar", "Três anos de uso", ClassificacaoEnum.EQUIPAMENTO, null, doacao6);
		
		*/
		
		usuarioRepository.saveAll(Arrays.asList(usuario1, usuario2, usuario3, usuario4 ,usuario5, usuario6));
		loginRepository.saveAll(Arrays.asList(login1, login2, login3, login4 ,login5, login6));
		//doacaoRepository.saveAll(Arrays.asList(doacao1, doacao2, doacao3, doacao4 ,doacao5, doacao6));
		//itemRepository.saveAll(Arrays.asList(item1, item2, item3, item4 ,item5, item6));	
	}
}
