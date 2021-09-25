package com.acc.amar.mais.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.acc.amar.mais.models.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	public UsuarioDto() {}
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.cpf = usuario.getCpf();
		this.email = usuario.getEmail();
		this.telefone = usuario.getTelefone();
		this.inscricao = usuario.getInscricao();
	}
	
	public UsuarioDto(Usuario usuario, String senha) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.sobrenome = usuario.getSobrenome();
		this.cpf = usuario.getCpf();
		this.email = usuario.getEmail();
		this.telefone = usuario.getTelefone();
		this.inscricao = usuario.getInscricao();
		this.senha = senha;	
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDateTime getInscricao() {
		return inscricao;
	}

	public void setInscricao(LocalDateTime inscricao) {
		this.inscricao = inscricao;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
