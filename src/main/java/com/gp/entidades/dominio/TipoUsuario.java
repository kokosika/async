package com.gp.entidades.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gp.entidades.aplicacion.Contraparte;
import com.gp.entidades.aplicacion.Empleado;
import com.gp.entidades.base.DomainEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "TBL_TIPO_USUARIO")
public class TipoUsuario extends DomainEntity {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUsuario")
    @JsonIgnore
    private Set<Contraparte> contrapartes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoUsuario")
    @JsonIgnore
    private Set<Empleado> empleados;

}
