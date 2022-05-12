package io.github.jeanls.simple_validator.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    private Utils() {

    }

    public static String listIntToMsg(final List<Integer> list) {
        return list.stream().map(Object::toString).collect(Collectors.joining(", "));
    }

    public static <S extends CharSequence> String listCharToMsg(final List<S> list) {
        return String.join(", ", list);
    }
}
