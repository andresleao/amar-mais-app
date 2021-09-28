package com.acc.amar.mais.dtos;

import javax.validation.constraints.NotEmpty;

public class LoginDto {

	private Integer id;
	
	@NotEmpty(message = "Campo EMAIL requerido!")
	private String email;
	
	@NotEmpty(message = "Campo SENHA requerido!")
	private String senha;
	
	private Integer usuario;
	
	public LoginDto() {}
	
	public LoginDto(UsuarioDto usuarioDto) {
		this.email = usuarioDto.getEmail();
		this.senha = usuarioDto.getSenha();
		this.usuario = usuarioDto.getId();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
}
