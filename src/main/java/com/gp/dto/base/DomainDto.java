package com.gp.dto.base;

/**
 * Entidad encargada de aportar con los campos para los dto de dominio
 * contiene de forma generica para todas las entidades de dominio el nombre
 * y la descripcion.
 * Hereda de la clase FechaEstadoDto que aportara con las fechas de creacion y ultimo update
 *
 * @see com.gp.dto.base.FechaEstadoDto
 *
 * @author Franco Cortez
 * @version 1.0
 */
public abstract class DomainDto extends FechaEstadoDto {

    private String nombre;
    private String descripcion;

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
