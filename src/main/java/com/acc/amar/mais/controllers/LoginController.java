package com.acc.amar.mais.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acc.amar.mais.dtos.CredenciaisDto;
import com.acc.amar.mais.dtos.TokenDto;
import com.acc.amar.mais.models.Login;
import com.acc.amar.mais.security.jwt.JwtService;
import com.acc.amar.mais.services.LoginService;
import com.acc.amar.mais.services.exceptions.DataIntegratyViolationException;
import com.acc.amar.mais.services.exceptions.SenhaInvalidaException;

@CrossOrigin("*")
@RestController
@RequestMapping("login")
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@GetMapping(value = "/{email}")
	public ResponseEntity<Integer> findByEmail(@PathVariable String email) {
		Login login = loginService.findByEmail(email);
		Integer userId = login.getId();
		return ResponseEntity.ok().body(userId);
	}
	
	@PostMapping
	public TokenDto autenticar(@RequestBody @Valid CredenciaisDto credenciais) {
		try {
			Login login = new Login();
			login.setEmail(credenciais.getEmail());
			login.setSenha(credenciais.getSenha());
			
			Login user = loginService.findByEmail(credenciais.getEmail());
			Integer idUser = user.getId();
			login.setId(idUser);
			
			UserDetails usuarioAutenticado = loginService.autenticar(login);
			
			String token = jwtService.gerarToken(login);
			return new TokenDto(login.getId(), login.getEmail(), token);
							
		} catch (UsernameNotFoundException e) {
			throw new DataIntegratyViolationException("Login inválido!");
		} catch (SenhaInvalidaException e) {
			throw new SenhaInvalidaException();	
		} 
	}
}
