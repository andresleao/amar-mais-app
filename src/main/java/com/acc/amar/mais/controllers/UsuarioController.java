package com.acc.amar.mais.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.acc.amar.mais.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.acc.amar.mais.dtos.UsuarioDto;
import com.acc.amar.mais.models.Usuario;
import com.acc.amar.mais.services.UsuarioService;

@CrossOrigin("*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	// Retornar todos os usuários
	@GetMapping
	public ResponseEntity<List<UsuarioDto>> findAll() {
		List<Usuario> usuarios = usuarioService.findAll();
		List<UsuarioDto> usuarioDtoList = new ArrayList<>();
		usuarios.forEach(usuario -> {
			UsuarioDto dto = UsuarioMapper.toDTO(usuario);
			usuarioDtoList.add(dto);
		});
		return ResponseEntity.ok().body(usuarioDtoList);
	}
	
	// Encontrar o usuário pelo id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		Usuario usuario = usuarioService.findById(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	@PostMapping
	public ResponseEntity<Integer> create(@RequestBody @Valid UsuarioDto usuarioDTO) {
		Usuario user = usuarioService.create(usuarioDTO);	
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").buildAndExpand(user.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(user.getId());		
	}	
}
