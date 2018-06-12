package com.gp.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gp.dto.aplicacion.UsuarioDto;
import com.gp.entidades.aplicacion.Usuario;
import com.gp.repositorios.interfaces.aplicacion.UsuarioRepositorio;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        UsuarioDto user = null;
		try {
			UsuarioDto a = new UsuarioDto();
			a.setEmail(usernameOrEmail);
			a.setUsername(usernameOrEmail);
			user = usuarioRepositorio.buscarPorNombreOrMail(a)
			        .orElseThrow(() ->
			                new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Usuario usuario = new Usuario(user.getId(),user.getName(), user.getUsername(),user.getEmail(), user.getPassword());
        return UsuarioPrincipal.create(usuario);
    }

    @Transactional
    public UserDetails loadUserById(Integer id) {
    	UsuarioDto user = null;
		try {
			user = usuarioRepositorio.buscarPorId(id).orElseThrow(
			    () -> new Exception("User")
			);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Usuario usuario = new Usuario(user.getId(),user.getName(), user.getUsername(),user.getEmail(), user.getPassword());
        return UsuarioPrincipal.create(usuario);
    }
}
