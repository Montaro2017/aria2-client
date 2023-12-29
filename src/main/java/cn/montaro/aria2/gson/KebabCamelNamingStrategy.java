package cn.montaro.aria2.gson;

import com.google.gson.FieldNamingStrategy;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KebabCamelNamingStrategy implements FieldNamingStrategy {

    private final List<Class<?>> classes = new ArrayList<>();

    public KebabCamelNamingStrategy(Class<?>... classes) {
        Collections.addAll(this.classes, classes);
    }

    @Override
    public String translateName(Field f) {
        String fieldName = f.getName();
        Class<?> declaringClass = f.getDeclaringClass();
        if (classes.contains(declaringClass)) {
            return kebabCase(fieldName);
        }
        return fieldName;
    }

    private String kebabCase(String fieldName) {
        StringBuilder kebabCaseName = new StringBuilder();
        for (int i = 0; i < fieldName.length(); i++) {
            char c = fieldName.charAt(i);
            if (Character.isUpperCase(c)) {
                if (kebabCaseName.length() > 0) {
                    kebabCaseName.append('-');
                }
                kebabCaseName.append(Character.toLowerCase(c));
            } else {
                kebabCaseName.append(c);
            }
        }
        return kebabCaseName.toString();
    }

}
