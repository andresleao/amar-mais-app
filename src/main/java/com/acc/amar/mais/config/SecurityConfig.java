package com.acc.amar.mais.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import com.acc.amar.mais.security.jwt.JwtAuthFilter;
import com.acc.amar.mais.security.jwt.JwtService;
import com.acc.amar.mais.services.LoginService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private LoginService loginService;
	
	@Autowired
	private JwtService jwtService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();	
	}
	
	@Bean
	public OncePerRequestFilter jwtFilter() {
		return new JwtAuthFilter(jwtService, loginService);
	}
		
	// Método para autenticar o usurário do sistema
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(loginService)
			.passwordEncoder(passwordEncoder());
	}
	
	// Método que verifica o nível de acesso do usuário autenticado na API
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	// Autenticação com JWT
		http
			.csrf().disable()
			.authorizeRequests()        //.authenticated()   .hasRole("USER")
				.antMatchers(HttpMethod.GET, "/pessoa").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers(HttpMethod.POST, "/usuario").permitAll()
				.antMatchers(HttpMethod.PUT, "/usuario/**").permitAll()
				.antMatchers(HttpMethod.GET, "/usuario/**").permitAll()
				.antMatchers("/doacao/**").permitAll()
				.antMatchers("/doacao").permitAll()
				.antMatchers("/item").permitAll()
				.antMatchers("/item/**").permitAll()
				
				.antMatchers("/h2-console/**").permitAll()
	            .anyRequest().authenticated()
	            .and().csrf().disable()
	            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            .and().headers().frameOptions().sameOrigin()
			.and()
				.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
				.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
