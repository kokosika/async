package com.gp.entidades.base;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Entidad base para los id de las entidades del sistema.
 */
@MappedSuperclass
public abstract class IntegerIdEntity {

    @Id
    @Column(name = "ID")
    protected Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
