package com.acc.amar.mais.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acc.amar.mais.dtos.UsuarioDto;
import com.acc.amar.mais.models.Login;
import com.acc.amar.mais.models.Usuario;
import com.acc.amar.mais.repositories.LoginRepository;
import com.acc.amar.mais.repositories.UsuarioRepository;
import com.acc.amar.mais.services.exceptions.DataIntegratyViolationException;
import com.acc.amar.mais.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private LoginRepository loginRepository;
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(
				() -> new ObjectNotFoundException("Usuário não encontrado! Id: " + id));
	}
	
	public Usuario create(UsuarioDto usuarioDTO) {
		if ((findByEmail(usuarioDTO) != null) && (findByCpf(usuarioDTO) != null)) {
			throw new DataIntegratyViolationException("CPF e Email já cadastrados!");
		}
		
		if (findByCpf(usuarioDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado!");
		}
		
		if (findByEmail(usuarioDTO) != null) {
			throw new DataIntegratyViolationException("Email já cadastrado!");
		}
		
		Usuario novoUsuario = new Usuario(null, usuarioDTO.getNome(), usuarioDTO.getSobrenome(), usuarioDTO.getCpf(),
				usuarioDTO.getEmail(), usuarioDTO.getCidade(), usuarioDTO.getBairro(), usuarioDTO.getTelefone());
		
		usuarioRepository.save(novoUsuario);	
		Usuario usuario = usuarioService.findById(novoUsuario.getId());
		
		Login login = new Login(null, usuario.getEmail(), usuarioDTO.getSenha(), usuario);
		loginRepository.save(login);
		
		return usuario;
	}
	
	private Usuario findByCpf(UsuarioDto usuarioDTO) {
		Usuario usuario = usuarioRepository.findByCpf(usuarioDTO.getCpf());
		if (usuario != null) {
			return usuario;
		}
		return null;
	}
	
	private Usuario findByEmail(UsuarioDto usuarioDTO) {
		Usuario usuario = usuarioRepository.findByEmail(usuarioDTO.getEmail());
		if (usuario != null) {
			return usuario;
		}
		return null;
	}
}
