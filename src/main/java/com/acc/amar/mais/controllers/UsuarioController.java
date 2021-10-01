package com.acc.amar.mais.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		List<UsuarioDto> usuarios = usuarioService.findAll()
				.stream()
				.map(usuario -> new UsuarioDto(usuario))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(usuarios);
	}
	
	// Encontrar o usuário pelo id
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		Usuario usuario = usuarioService.findById(id);
		return ResponseEntity.ok().body(usuario);
	}
	
//	@GetMapping(value = "/{email}")
//	public ResponseEntity<Usuario> findByEmail(@PathVariable String email) {
//		Usuario usuario = usuarioService.findByEmail(email);
//		return ResponseEntity.ok().body(usuario);
//	}
	
	@PostMapping
	public ResponseEntity<Integer> create(@RequestBody @Valid UsuarioDto usuarioDTO) {
		Usuario user = usuarioService.create(usuarioDTO);	
		
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}").buildAndExpand(user.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(user.getId());		
	}	
	
	@PutMapping(value = "/{email}")
	public ResponseEntity<UsuarioDto> update(@PathVariable String email, @Valid @RequestBody UsuarioDto userDTO) {
		Usuario obj = usuarioService.update(email, userDTO);
		UsuarioDto newObj = new UsuarioDto(obj);
		return ResponseEntity.ok().body(newObj);
	}
}
