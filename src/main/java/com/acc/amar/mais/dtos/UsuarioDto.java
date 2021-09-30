package com.acc.amar.mais.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import com.acc.amar.mais.models.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "O campo NOME é requerido")
	private String nome;
	
	@NotEmpty(message = "O campo SOBRENOME é requerido")
	private String sobrenome;
	
	@CPF
	@NotEmpty(message = "O campo CPF é requerido")
	private String cpf;
	
	@NotEmpty(message = "O campo EMAIL é requerido")
	private String email;
	
	@NotEmpty(message = "O campo TELEFONE é requerido")
	private String telefone;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime inscricao;
	
	@NotEmpty(message = "O campo SENHA é requerido")
	private String senha;
}
