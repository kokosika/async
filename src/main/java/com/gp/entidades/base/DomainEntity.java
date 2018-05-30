package com.gp.entidades.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Creacion de las entidades de dominio dentro del sistema.
 * Ayudara a la creacion de todas las tablas de dominio del sistema
 *
 * @author Franco Cortez
 * @version 1.0
 * @see com.gp.entidades.base.IntegerIdEntity
 * @see com.gp.entidades.base.FechaEstadoEntity
 */
@MappedSuperclass
public abstract class DomainEntity extends FechaEstadoEntity {

    @Column(name = "NOMBRE", nullable = false, length = 50)
    protected String nombre;
    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    protected String descripcion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
