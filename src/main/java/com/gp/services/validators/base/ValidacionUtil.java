package com.gp.services.validators.base;

import java.util.Objects;

public class ValidacionUtil {

    public static final BaseValidacion<String> notNullString = ValidacionGenerica.from(Objects::nonNull);
    public static final BaseValidacion<String> notEmptyString = ValidacionGenerica.from(s -> !s.isEmpty());
    public static final BaseValidacion<Integer> notNullInteger = ValidacionGenerica.from(Objects::nonNull);
    public static final BaseValidacion<Integer> greaterThanZero = ValidacionGenerica.from(s -> s > 0);

    public static BaseValidacion<String> stringMoreThan(int size) {
        return ValidacionGenerica.from(s -> ((String) s).length() > size);
    };

    public static BaseValidacion<String> stringLessThan(int size) {
        return ValidacionGenerica.from(s -> ((String) s).length() < size);
    };

    public static BaseValidacion<String> stringBetween(int morethan, int lessThan) {
        return stringMoreThan(morethan).and(stringLessThan(lessThan));
    };

    public static BaseValidacion<Integer> integerMoreThan(int limit) {
        return ValidacionGenerica.from(s -> s > limit);
    };

    public static BaseValidacion<Integer> integerLessThan(int size) {
        return ValidacionGenerica.from(s -> s < size);
    };

    public static BaseValidacion<Integer> integerBetween(int morethan, int lessThan) {
        return integerMoreThan(morethan).and(integerLessThan(lessThan));
    };
}
