package br.com.simplevalidator.utils;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class Bundle {

    private static Bundle instance;
    private final ResourceBundle resourceBundle = ResourceBundle.getBundle("words", Locale.getDefault());

    private Bundle() {

    }

    public static Bundle getInstance() {
        if (instance == null) {
            instance = new Bundle();
            return instance;
        }
        return instance;
    }

    public String get(final String key, final String[] customMessage, final Object ... args) {
        if (customMessage != null && customMessage.length > 0 && customMessage[0] != null) {
            return customMessage[0];
        }
        final String pattern = resourceBundle.getString(key);
        return MessageFormat.format(pattern, args);
    }
}
