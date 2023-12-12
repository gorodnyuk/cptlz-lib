package ru.gorodnyuk.cptlz;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class FieldExtraction {

    static List<Field> getStringFields(Object o, String[] fieldsNames) {
        Class<?> aClass = o.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        return Arrays.stream(declaredFields)
                .filter(field -> field.getType().equals(String.class)
                        && Arrays.stream(fieldsNames).anyMatch(s -> s.equals(field.getName())))
                .collect(Collectors.toList());
    }
}
