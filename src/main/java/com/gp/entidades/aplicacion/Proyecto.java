package com.gp.entidades.aplicacion;

import com.gp.entidades.base.FechaEstadoEntity;
import com.gp.entidades.dominio.EstadoProyecto;
import com.gp.entidades.dominio.EtapaProyecto;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "TBL_PROYECTO")
public class Proyecto extends FechaEstadoEntity {

    @Column(length = 50, unique = true, nullable = false)
    private String nombre;
    @Column(length = 100)
    private String descripcion;
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    private Double porcentajeEsperado;
    private Double porcentajeReal;
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EtapaProyecto etapaProyecto;
    @JoinColumn(referencedColumnName = "id")
    @ManyToOne(optional = false)
    private EstadoProyecto estadoProyecto;

}
