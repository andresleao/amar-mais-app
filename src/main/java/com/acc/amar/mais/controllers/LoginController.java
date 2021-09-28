package com.acc.amar.mais.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acc.amar.mais.dtos.CredenciaisDto;
import com.acc.amar.mais.dtos.TokenDto;
import com.acc.amar.mais.models.Login;
import com.acc.amar.mais.models.Usuario;
import com.acc.amar.mais.security.jwt.JwtService;
import com.acc.amar.mais.services.LoginService;
import com.acc.amar.mais.services.exceptions.DataIntegratyViolationException;
import com.acc.amar.mais.services.exceptions.SenhaInvalidaException;

@RestController
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public void salvar(@RequestBody @Valid Login login) {
//			String senhaCriptografada = passwordEncoder.encode(login.getSenha());
//			login.setSenha(senhaCriptografada);
//			this.loginService.salvar(login);	
//	}
	
	@PostMapping
	public TokenDto autenticar(@RequestBody @Valid CredenciaisDto credenciais) {
		try {
			Login login = new Login();
			login.setEmail(credenciais.getEmail());
			login.setSenha(credenciais.getSenha());
			System.out.println(login.getEmail());
			System.out.println(login.getSenha());
			
			UserDetails usuarioAutenticado = loginService.autenticar(login);
			
			String token = jwtService.gerarToken(login);
			return new TokenDto(login.getEmail(), token);
							
		} catch (UsernameNotFoundException e) {
			throw new DataIntegratyViolationException("Login inválido!");
		} catch (SenhaInvalidaException e) {
			throw new SenhaInvalidaException();	
		} 
	}
}
