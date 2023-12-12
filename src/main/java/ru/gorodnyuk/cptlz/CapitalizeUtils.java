package ru.gorodnyuk.cptlz;

import java.lang.reflect.Field;
import java.util.List;

public class CapitalizeUtils {

    public static void capitalize(Object o, String... fieldsNames) {
        if (fieldsNames == null || fieldsNames.length == 0) {
            throw new IllegalArgumentException("List of fields for capitalize cannot be empty!");
        }

        List<Field> selectedFieldsInObject = FieldExtractor.getStringFields(o, fieldsNames);

        if (selectedFieldsInObject.isEmpty()) {
            return;
        }

        selectedFieldsInObject.forEach(field -> {
            field.setAccessible(true);
            try {
                field.set(o, capitalize((String) field.get(o)));
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Some exception :(", e);
            }
        });
    }

    private static String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
}
