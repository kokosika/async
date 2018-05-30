package com.gp.services.validators.base;

public class ValidacionUtilMethod {
    public String validarStringNotNullAndNotEmpty(String campo, String mensaje) {
        return ValidacionUtil.notNullString.or(ValidacionUtil.notEmptyString).resultadoGenerico(campo).getFieldNameIfInvalid(mensaje).orElse("");
    }

    public String validarStringNotNull(String campo, String mensaje) {
        return ValidacionUtil.notNullString.resultadoGenerico(campo).getFieldNameIfInvalid(mensaje).orElse("");
    }

    public String validarStringEmpty(String campo, String mensaje) {
        return ValidacionUtil.notEmptyString.resultadoGenerico(campo).getFieldNameIfInvalid(mensaje).orElse("");
    }

    public String validarIntegerNotNullAndNotEmpty(Integer campo, String mensaje) {
        return ValidacionUtil.notNullInteger.and(ValidacionUtil.greaterThanZero).resultadoGenerico(campo).getFieldNameIfInvalid(mensaje).orElse("");
    }
}
