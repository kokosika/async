package com.gp.entidades.base;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Fechas de seguimientos de creacion y modificacion de los registros.
 *
 * @author Franco Cortez
 * @version 1.0
 * @see com.gp.entidades.base.IntegerIdEntity
 */
@MappedSuperclass
public abstract class FechaEstadoEntity extends IntegerIdEntity {

    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_CREACION")
    protected Date fechaCreacion;
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_ULTIMO_UPDATE")
    protected Date fechaUltimoUpdate;

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
