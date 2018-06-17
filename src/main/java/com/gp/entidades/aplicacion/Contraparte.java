package com.gp.entidades.aplicacion;

import com.gp.entidades.base.FechaEstadoEntity;
import com.gp.entidades.dominio.TipoUsuario;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "TBL_CONTRAPARTE")
public class Contraparte extends FechaEstadoEntity {

    private String nombre;
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoUsuario tipoUsuario;
}
