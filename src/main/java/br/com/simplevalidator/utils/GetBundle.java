package br.com.simplevalidator.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class GetBundle {

    private static GetBundle instance;
    private final ResourceBundle bundle = ResourceBundle.getBundle("words", Locale.getDefault());

    private GetBundle() {

    }

    public static GetBundle getInstance() {
        if (instance == null) {
            instance = new GetBundle();
            return instance;
        }
        return instance;
    }

    public String get(final String key, final Object ... args) {
        final String pattern = bundle.getString(key);
        return MessageFormat.format(pattern, args);
    }
}
