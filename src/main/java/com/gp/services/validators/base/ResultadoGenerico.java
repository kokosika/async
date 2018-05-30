package com.gp.services.validators.base;

import java.util.Optional;

public class ResultadoGenerico {

    private boolean valid;
    private ResultadoGenerico(boolean valid) {
        this.valid = valid;
    }
    public static ResultadoGenerico ok() {
        return new ResultadoGenerico(true);
    }

    public static ResultadoGenerico fail() {
        return new ResultadoGenerico(false);
    }

    public boolean isValid() {
        return valid;
    }

    public Optional<String> getFieldNameIfInvalid(String field) {
        return this.valid ? Optional.empty() : Optional.of(field);
    }
}
