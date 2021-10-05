package com.acc.amar.mais;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.acc.amar.mais.models.Usuario;

public class UsuarioTest {
	
	@Test
	public void createNewUsuario() {
		Usuario usuario = new Usuario(1, "diego", "teixeira", "123", "diego@gmail.com", "recife", "boa viagem", "8199999999");
		assertNotNull(usuario);
	}
	
	@Test
	public void createEmptyUser() {
		Usuario usuario = new Usuario();
		assertNotNull(usuario);
		
		usuario.setId(1);
		usuario.setNome("Diego");
		usuario.setSobrenome("Rodrigues");
		usuario.setCpf("123");
		usuario.setEmail("teste@gmail.com");
		usuario.setCidade("recife");
		usuario.setBairro("bv");
		usuario.setTelefone("123");
		
		assertEquals(1, usuario.getId());
		assertEquals("Diego", usuario.getNome());
		assertEquals("Rodrigues", usuario.getSobrenome());
		assertEquals("123", usuario.getCpf());
		assertEquals("teste@gmail.com", usuario.getEmail());
		assertEquals("recife", usuario.getCidade());
		assertEquals("bv", usuario.getBairro());
		assertEquals("123", usuario.getTelefone());
	}

}
