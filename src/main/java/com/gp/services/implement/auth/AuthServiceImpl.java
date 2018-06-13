package com.gp.services.implement.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gp.dto.aplicacion.UsuarioDto;
import com.gp.dto.response.JwtAuthenticationResponse;
import com.gp.dto.response.LoginRequest;
import com.gp.dto.response.SignUpRequest;
import com.gp.repositorios.interfaces.aplicacion.UsuarioRepositorio;
import com.gp.seguridad.JwtTokenProvider;
import com.gp.services.interfaces.auth.AuthService;

import io.reactivex.Observable;

/**
 * Implementacion basica de los servicios de authentificacion.
 * +
 * 
 * @author Franco Cortez
 * @version 1.0
 */
@Service
public class AuthServiceImpl implements AuthService {
	
	/**
	 * Injeccion del logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceImpl.class);

	/**
	 * Injeccion del AuthenticationManager.
	 */
	private final AuthenticationManager authenticationManager;
	/**
	 * Injeccion del JwtTokenProvider.
	 */
	private final JwtTokenProvider jwtTokenProvider;
	
	/**
	 * Injeccion del password encoder.
	 */
	private final PasswordEncoder passwordEncoder;
	
	/**
	 * Injeccion del Usuario Repositorio.
	 */
	private final UsuarioRepositorio usuarioRepositorio;
	
	/**
	 * Injeccion de las dependencias necesarias para la auth.
	 */
	public AuthServiceImpl(final AuthenticationManager authenticationManager, 
			final JwtTokenProvider jwtTokenProvider, 
			final PasswordEncoder passwordEncoder,
			final UsuarioRepositorio usuarioRepositorio) {
		LOGGER.info("Injección de las dependecias de la clase.");
		this.authenticationManager = authenticationManager;
		this.jwtTokenProvider = jwtTokenProvider;
		this.passwordEncoder = passwordEncoder;
		this.usuarioRepositorio = usuarioRepositorio;
	}
	
	/**
	 * Metodo de authentificacion de sistema.
	 * @param loginRequest parametros de entrada para el login
	 * @return el token.
	 */
	public Observable<JwtAuthenticationResponse> login(LoginRequest loginRequest) {
		LOGGER.info("[login] = PRE-OBSERVABLE ");
		return Observable.create(source -> {
			try {
				LOGGER.info("[login] = BEGIN ");
				LOGGER.info("[login] = Inicio authentication ");
				Authentication authentication = authenticationManager.authenticate(
		                new UsernamePasswordAuthenticationToken(
		                        loginRequest.getUsernameOrEmail(),
		                        loginRequest.getPassword()
		                )
		        );
				LOGGER.info("[login] = Obtener el context ");
		        SecurityContextHolder.getContext().setAuthentication(authentication);
		        LOGGER.info("[login] = Generar el Token ");
		        String jwt = jwtTokenProvider.generateToken(authentication);
		        LOGGER.info("[login] = Enviar el token ");
		        source.onNext(new JwtAuthenticationResponse(jwt));
		        LOGGER.info("[login] = END ");
		        source.onComplete();
			} catch (Exception e) {
				LOGGER.info("[login] = TRHOW = " + e.getMessage());
				source.onError(e);
			}
		});
	}
	
	public Observable<UsuarioDto> registrar (SignUpRequest signUpRequest){
		LOGGER.info("[registrar] = PRE-OBSERVABLE ");
		return Observable.create(source -> {			
			try {
				LOGGER.info("[registrar] = BEGIN ");
				LOGGER.info("[registrar] = Crear usuario ");
				UsuarioDto usuario = new UsuarioDto(signUpRequest.getEmail(), signUpRequest.getName(), signUpRequest.getPassword(), signUpRequest.getUsername());
				LOGGER.info("[registrar] = Encriptar contraceña ");
				usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
				LOGGER.info("[registrar] = Guardar. en el repositorio ");
		        source.onNext(this.usuarioRepositorio.guardar(usuario).get());
		        LOGGER.info("[registrar] = END ");
		        source.onComplete();				
			} catch (Exception e) {
				LOGGER.info("[registrar] = THROW " + e.getMessage());
				source.onError(e);
			}
		});
	}
}
