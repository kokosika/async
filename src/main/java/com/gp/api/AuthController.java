package com.gp.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gp.dto.aplicacion.UsuarioDto;
import com.gp.dto.response.JwtAuthenticationResponse;
import com.gp.dto.response.LoginRequest;
import com.gp.dto.response.SignUpRequest;
import com.gp.repositorios.interfaces.aplicacion.UsuarioRepositorio;
import com.gp.repositorios.interfaces.dominio.TipoUsuarioRepositorio;
import com.gp.seguridad.JwtTokenProvider;



public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UsuarioRepositorio userRepository;

    @Autowired
    TipoUsuarioRepositorio roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {       
        UsuarioDto user = new UsuarioDto(signUpRequest.getEmail(), signUpRequest.getName(), signUpRequest.getPassword(), signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UsuarioDto result = null;
		try {
			result = userRepository.guardar(user).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return new ResponseEntity<>(result,HttpStatus.ACCEPTED);
    }
}