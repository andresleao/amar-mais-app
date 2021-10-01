package com.acc.amar.mais.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Autowired
	private PasswordEncoder encoder;
	
	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Integer id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario.orElseThrow(
				() -> new ObjectNotFoundException("Usuário não encontrado! Id: " + id));
	}
	
//	public Usuario findByEmail(String email) {
//		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
//		Usuario usuario = usuarioRepository.
//		return usuario;
//	}
	
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
		
		Login login = new Login(null, usuario.getEmail(), encoder.encode(usuarioDTO.getSenha()), usuario);
		loginRepository.save(login);
		
		return usuario;
	}
	
	public Usuario update(String email, @Valid UsuarioDto usuarioDTO) {
		Usuario oldUser = findByEmail(usuarioDTO);
		
		if (findByCpf(usuarioDTO) != null && !findByCpf(usuarioDTO).getEmail().equals(email)) {
			throw new DataIntegratyViolationException("CPF já cadastrado!");
		}
		
		if ((findByEmail(usuarioDTO) == null) || (!findByEmail(usuarioDTO).getEmail().equals(email))) {
			throw new DataIntegratyViolationException("Não é possível alterar o email da conta!");
		}
		
		oldUser.setId(oldUser.getId());
		oldUser.setNome(usuarioDTO.getNome());
		oldUser.setSobrenome(usuarioDTO.getSobrenome());
		oldUser.setCpf(usuarioDTO.getCpf());
		oldUser.setEmail(usuarioDTO.getEmail());
		oldUser.setCidade(usuarioDTO.getCidade());
		oldUser.setBairro(usuarioDTO.getBairro());
		oldUser.setTelefone(usuarioDTO.getTelefone());
		usuarioRepository.save(oldUser);
		
		Login login = new Login(oldUser.getId(), oldUser.getEmail(), encoder.encode(usuarioDTO.getSenha()), oldUser);
		loginRepository.save(login);
		
		return oldUser;
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
