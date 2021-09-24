package com.acc.amar.mais.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acc.amar.mais.dtos.UsuarioDto;
import com.acc.amar.mais.models.Usuario;
import com.acc.amar.mais.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	// Retornar todos os usuários
	@GetMapping
	public ResponseEntity<List<UsuarioDto>> findAll() {
		List<UsuarioDto> usuarios = usuarioService.findAll()
				.stream()
				.map(usuario -> new UsuarioDto(usuario))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(usuarios);
	}
	
	// Encontrar o usuário pelo id
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDto> findById(@PathVariable Integer id) {
		Usuario usuario = usuarioService.findById(id);
		UsuarioDto usuarioDTO = new UsuarioDto(usuario);
		return ResponseEntity.ok().body(usuarioDTO);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody UsuarioDto usuarioDTO) {
		usuarioService.create(usuarioDTO);
	}
	
}
