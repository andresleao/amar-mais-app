package com.acc.amar.mais.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.acc.amar.mais.models.Login;
import com.acc.amar.mais.repositories.LoginRepository;
import com.acc.amar.mais.services.exceptions.DataIntegratyViolationException;
import com.acc.amar.mais.services.exceptions.SenhaInvalidaException;

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private LoginRepository repository;
	
//	@Transactional
//	public Login salvar(Login login) {
//		boolean existsByLogin = repository.existsByEmail(login.getEmail());
//		
//		if (existsByLogin) {
//			throw new DataIntegratyViolationException("Usuário já cadastrado!");
//		}
//		return repository.save(login);
//	}
	
	public UserDetails autenticar(Login login) {
		UserDetails user = loadUserByUsername(login.getEmail());
		System.out.println(user.getUsername());
		login.getSenha();
		user.getPassword();
		boolean senhasConferem = encoder.matches(login.getSenha(), user.getPassword());
		System.out.println(senhasConferem);
		if (senhasConferem) {
			return user;
		}
		throw new SenhaInvalidaException();
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Login login = repository.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Login não encontrado!"));
				
		return User
				.builder()
				.username(login.getEmail())
				.password(login.getSenha())
				.roles("USER")
				.build();	
	}
}
