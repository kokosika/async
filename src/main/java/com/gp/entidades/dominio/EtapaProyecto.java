package com.gp.entidades.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gp.entidades.aplicacion.Proyecto;
import com.gp.entidades.base.DomainEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "TBL_ETAPA_PROYECTO")
public class EtapaProyecto extends DomainEntity {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapaProyecto")
    @JsonIgnore
    private Set<Proyecto> proyectos;

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }
}
