package com.gp.entidades.dominio;

import com.gp.entidades.base.DomainEntity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "TBL_PROVINCIA")
public class Provincia extends DomainEntity {
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Region region;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provincia")
    private Set<Comuna> comunas;
}
