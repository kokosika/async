package com.gp.entidades.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gp.entidades.base.DomainEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity(name = "TBL_REGION")
public class Region extends DomainEntity {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region")
    @JsonIgnore
    private Set<Provincia> provincias;
}
