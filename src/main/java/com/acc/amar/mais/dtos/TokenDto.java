package com.acc.amar.mais.dtos;

public class TokenDto {

	private Integer id;
	private String login;
	private String token;
	
	public TokenDto() {}
	
	public TokenDto(Integer id, String login, String token) {
		this.id = id;
		this.login = login;
		this.token = token;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}	
}
