package io.github.jeanls.simplevalidator.utils;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Utils {

    private static final List<String> supportedLocales = List.of("pt-BR", "en-US");

    private Utils() {

    }

    public static String listIntToMsg(final List<Integer> list) {
        return list.stream().map(Object::toString).collect(Collectors.joining(", "));
    }

    public static boolean isEmptyString(final CharSequence val) {
        if (val == null) {
            return true;
        }
        return ((String)val).trim().length() == 0;
    }

    public static <S extends CharSequence> String listCharToMsg(final List<S> list) {
        return String.join(", ", list);
    }

    public static Locale getDefaultLocale() {
        if (!supportedLocales.contains(Locale.getDefault().toLanguageTag())) {
            return Locale.US;
        }
        return Locale.getDefault();
    }
}
