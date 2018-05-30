package com.gp.entidades.dominio;

import com.gp.entidades.base.DomainEntity;

import javax.persistence.Entity;

/**
 * Entidad encargada de registrar todos los tipos de usuario del sistema.
 *
 * @author Franco Cortez
 * @version 1.0
 * @see com.gp.entidades.base.FechaEstadoEntity
 * @see com.gp.entidades.base.IntegerIdEntity
 * @see com.gp.entidades.base.DomainEntity
 */
@Entity(name = "TBL_TIPO_USUARIO")
public class TipoUsuario extends DomainEntity {
}
