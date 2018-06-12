package com.gp.services.interfaces.auth;

import com.gp.dto.response.JwtAuthenticationResponse;
import com.gp.dto.response.LoginRequest;

import io.reactivex.Observable;

public interface AuthService {
	
	/**
	 * Metodo de authentificacion de sistema.
	 * @param loginRequest parametros de entrada para el login
	 * @return el token.
	 */
	public Observable<JwtAuthenticationResponse> login(LoginRequest loginRequest);

}
