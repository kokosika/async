package com.gp.services.validators.base;

@FunctionalInterface
public interface BaseValidacion<K> {

    ResultadoGenerico resultadoGenerico(K param);

    default BaseValidacion<K> and(BaseValidacion<K> otro){
        return (param) -> {
            ResultadoGenerico resultado = this.resultadoGenerico(param);
            return !resultado.isValid() ? resultado : otro.resultadoGenerico(param);
        };
    }

    default BaseValidacion<K> or(BaseValidacion<K> otro) {
        return (param) -> {
            ResultadoGenerico result = this.resultadoGenerico(param);
            return result.isValid() ? result : otro.resultadoGenerico(param);
        };
    }
}
