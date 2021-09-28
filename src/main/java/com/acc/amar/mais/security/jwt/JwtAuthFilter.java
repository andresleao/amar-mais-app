package com.acc.amar.mais.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.acc.amar.mais.services.LoginService;
import com.acc.amar.mais.services.UsuarioService;

public class JwtAuthFilter extends OncePerRequestFilter {

	private JwtService jwtService;
	private LoginService loginService;
	
	public JwtAuthFilter(JwtService jwtService, LoginService loginService) {
		this.jwtService = jwtService;
		this.loginService = loginService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorization = request.getHeader("Authorization");
		/* 
		  Verifica se o token não está nulo e começa com Bearer = token na formatação válida:
		  	Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJGZWxpcGUiLCJleHAiOjE2MzI3NTA5MDR9
		  	.xS5huHBD8UhYEYewl1c5ficAYFOQ7Ke8vqtnlhgTOEuh765AhnAG25GG1rHsSuecb2oSP4kMQAJwJ4DIZzAG9g
		 */
		 
		if (authorization != null && authorization.startsWith("Bearer")) {
			String token = authorization.split(" ")[1];
			boolean isValid = jwtService.tokenValido(token);
			
			if (isValid) {
				String loginUsuario = jwtService.obterLoginUsuario(token);
				UserDetails usuario = loginService.loadUserByUsername(loginUsuario);
				UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(
						usuario, null, usuario.getAuthorities());
				user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(user);
			}
		}
		filterChain.doFilter(request, response);	
	}
}
