package com.acc.amar.mais;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.acc.amar.mais.models.enuns.ClassificacaoEnum;

public class ClassificacaoEnumTest {
	
	@Test
	public void classificacaoEnumShouldReturnNullWhenIdIsZero() {
		assertEquals(null, ClassificacaoEnum.toEnum(0));
	}
	
	@Test
	public void classificacaoEnumShouldReturnEnumWhenValidId() {
		assertEquals(ClassificacaoEnum.MEDICACAO, ClassificacaoEnum.toEnum(1));
		assertEquals(ClassificacaoEnum.MOBILIARIO, ClassificacaoEnum.toEnum(2));
		assertEquals(ClassificacaoEnum.EQUIPAMENTO, ClassificacaoEnum.toEnum(3));
	}
	
	@Test
	public void classificacaoEnumShouldReturnNullWhenDescriptionIsNull() {
		assertEquals(null, ClassificacaoEnum.toEnum(null));
	}
	
	@Test
	public void classificacaoEnumShouldReturnEnumWhenValidDescription() {
		assertEquals(ClassificacaoEnum.MEDICACAO, ClassificacaoEnum.toEnum("Medicação"));
		assertEquals(ClassificacaoEnum.MOBILIARIO, ClassificacaoEnum.toEnum("Moboliario"));
		assertEquals(ClassificacaoEnum.EQUIPAMENTO, ClassificacaoEnum.toEnum("Equipamento"));
	}
	
	@Test
	public void classificacaoEnumThrownsExceptionWhenIdIsInvalid() {
	    assertThrows(IllegalArgumentException.class, () -> {
	    	ClassificacaoEnum.toEnum(4);
	    	ClassificacaoEnum.toEnum(-1);
	    });
	}
	
	@Test
	public void classificacaoEnumThrownsExceptionWhenDescriptionIsInvalid() {
	    assertThrows(IllegalArgumentException.class, () -> {
	    	ClassificacaoEnum.toEnum("Alguma Coisa");
	    	ClassificacaoEnum.toEnum("");
	    });
	}
}
