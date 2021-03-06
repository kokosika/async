package com.gp.entidades.aplicacion;

import com.gp.entidades.base.FechaEstadoEntity;
import com.gp.entidades.dominio.RolUsuario;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidad encargada de registrar todos los usuarios del sistema
 *
 * @author Franco Cortez
 * @version 1.0
 * @see com.gp.entidades.base.FechaEstadoEntity
 * @see com.gp.entidades.base.IntegerIdEntity
 */
@Entity(name = "TBL_USUARIOS")
public class Usuario extends FechaEstadoEntity {

	
    @NotBlank
    @Size(max = 40)
    private String name;

    @NotBlank
    @Size(max = 15)
    private String username;

    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;

    @NotBlank
    @Size(max = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "TBL_USUARIO_ROLES",
            joinColumns = @JoinColumn(name = "USUARIO_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLES_ID"))
    private Set<RolUsuario> roles = new HashSet<>();

    public Usuario(Integer id,String name, String username, String email, String password) {
    	this.id = id;
    	this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    
    public Usuario() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

    public Set<RolUsuario> getRoles() {
		return roles;
	}

    public void setRoles(Set<RolUsuario> roles) {
		this.roles = roles;
	}
    
    
}
