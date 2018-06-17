package com.gp.entidades.aplicacion;

import com.gp.entidades.base.FechaEstadoEntity;

import javax.persistence.Entity;

@Entity(name = "TBL_CLIENTE")
public class Cliente extends FechaEstadoEntity {

    private String nombre;
    private String logo;
}

