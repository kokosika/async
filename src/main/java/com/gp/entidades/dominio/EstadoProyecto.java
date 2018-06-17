package com.gp.entidades.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gp.entidades.aplicacion.Proyecto;
import com.gp.entidades.base.DomainEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "TBL_ESTADO_PROYECTO")
public class EstadoProyecto extends DomainEntity {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoProyecto")
    @JsonIgnore
    private Set<Proyecto> proyectos;

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
}
