package com.acc.amar.mais;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

import com.acc.amar.mais.models.Doacao;
import com.acc.amar.mais.models.Usuario;

public class DoacaoTest {
	
	@Test
	public void DoacaoReturn() {
		Doacao doacao = new Doacao(1, LocalDateTime.now(), new Usuario(), 10);
		assertEquals(1, doacao.getId());
	}
	
	@Test
	public void createEmptyDoacao() {
		Doacao doacao = new Doacao();
		assertNotNull(doacao);
	}
	
	@Test
	public void addingAtributesToEmptyObjectDoacao() {
		Doacao doacao = new Doacao();
		doacao.setAtivo(true);
		assertTrue(doacao.isAtivo());
		
		doacao.setId(1);
		assertEquals(1, doacao.getId());
		
		doacao.setUsuario(new Usuario());
		assertNotNull(doacao.getUsuario());
		
		doacao.setIdDonatario(10);
		assertEquals(10, doacao.getIdDonatario());
	}

}
