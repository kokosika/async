package com.gp.dto.base;

import java.util.Date;

/**
 * Clase que contendra todas las fechas de creacion y fechas de ultimas modificaciones
 * para obtener estadisticas de las entidades en donde se ejecutan dml.
 *
 * Hereda de la clase IntegerIdDto la que proporcionara los id de las entidades.
 *
 * @see com.gp.dto.base.IntegerIdDto
 *
 * @author Franco Cortez
 * @version 1.0
 */
public abstract class FechaEstadoDto extends IntegerIdDto {

    private Date fechaCreacion;
    private Date fechaUltimoUpdate;
    
    public FechaEstadoDto() {super ();}
    public FechaEstadoDto (Integer id ,Date fechaCreacion, Date fechaUltimoUpdate) {
    	super(id);
    	this.fechaCreacion = fechaCreacion;
    	this.fechaUltimoUpdate = fechaUltimoUpdate;
    }
    

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaUltimoUpdate() {
        return fechaUltimoUpdate;
    }

    public void setFechaUltimoUpdate(Date fechaUltimoUpdate) {
        this.fechaUltimoUpdate = fechaUltimoUpdate;
    }
}
