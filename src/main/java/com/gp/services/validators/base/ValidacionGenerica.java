package com.gp.services.validators.base;

import java.util.function.Predicate;

public class ValidacionGenerica<K> implements BaseValidacion<K> {

    private Predicate<K> predicate;

    private ValidacionGenerica(Predicate<K> predicate) {
        this.predicate = predicate;
    }

    public static <K> ValidacionGenerica<K> from(Predicate<K> predicate) {
        return new ValidacionGenerica<K>(predicate);
    }

    @Override
    public ResultadoGenerico resultadoGenerico(K param) {
        return predicate.test(param) ? ResultadoGenerico.ok() : ResultadoGenerico.fail();
    }
}
