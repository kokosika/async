package com.gp.services.implement.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.gp.dto.response.JwtAuthenticationResponse;
import com.gp.dto.response.LoginRequest;
import com.gp.seguridad.JwtTokenProvider;
import com.gp.services.interfaces.auth.AuthService;

import io.reactivex.Observable;

/**
 * Implementacion basica de los servicios de authentificacion.
 * 
 * @author Franco Cortez
 * @version 1.0
 */
@Service
public class AuthServiceImpl implements AuthService {

	/**
	 * Injeccion del AuthenticationManager
	 */
	private final AuthenticationManager authenticationManager;
	/**
	 * Injeccion del JwtTokenProvider
	 */
	private final JwtTokenProvider jwtTokenProvider;
	
	/**
	 * Injeccion de las dependencias necesarias para la auth.
	 */
	public AuthServiceImpl(final AuthenticationManager authenticationManager, final JwtTokenProvider jwtTokenProvider) {
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	/**
	 * Metodo de authentificacion de sistema.
	 * @param loginRequest parametros de entrada para el login
	 * @return el token.
	 */
	public Observable<JwtAuthenticationResponse> login(LoginRequest loginRequest) {
		return Observable.create(source -> {
			try {
				Authentication authentication = authenticationManager.authenticate(
		                new UsernamePasswordAuthenticationToken(
		                        loginRequest.getUsernameOrEmail(),
		                        loginRequest.getPassword()
		                )
		        );
		        SecurityContextHolder.getContext().setAuthentication(authentication);
		        String jwt = jwtTokenProvider.generateToken(authentication);
		        source.onNext(new JwtAuthenticationResponse(jwt));
		        source.onComplete();
				
			} catch (Exception e) {
				source.onError(e);
			}
		});
	}
}
