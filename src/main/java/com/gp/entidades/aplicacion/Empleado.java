package com.gp.entidades.aplicacion;

import com.gp.entidades.base.FechaEstadoEntity;
import com.gp.entidades.dominio.Comuna;
import com.gp.entidades.dominio.TipoUsuario;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "TBL_EMPLEADO")
public class Empleado extends FechaEstadoEntity {

    private String nombre;
    private String apellido;
    private String correo;
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Comuna comuna;
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoUsuario tipoUsuario;
}
