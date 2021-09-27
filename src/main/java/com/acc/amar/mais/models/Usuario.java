package com.acc.amar.mais.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobrenome;
	
	@Column(unique = true)
	private String cpf;
	
	@Column(unique = true)
	private String email;
	
	private String cidade;
	private String bairro;
	
	private String telefone;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime inscricao;
	
	public Usuario() {}

	public Usuario(Integer id, String nome, String sobrenome, String cpf, String email, String cidade, String bairro,
			String telefone) {

		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.cidade = cidade;
		this.bairro = bairro;
		this.telefone = telefone;
		this.inscricao = LocalDateTime.now();
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
	
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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
}
