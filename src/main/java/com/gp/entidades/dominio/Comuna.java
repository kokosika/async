package com.gp.entidades.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gp.entidades.aplicacion.Empleado;
import com.gp.entidades.base.DomainEntity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "TBL_COMUNA")
public class Comuna extends DomainEntity {

    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Provincia provincia;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comuna")
    @JsonIgnore
    private Set<Empleado> empleados;

}
