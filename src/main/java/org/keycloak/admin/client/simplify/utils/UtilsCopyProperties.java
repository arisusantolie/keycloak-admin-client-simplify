package org.keycloak.admin.client.simplify.utils;


import java.lang.reflect.Field;

public class UtilsCopyProperties {

    public static void copyNonNullProperties(Object source, Object target) {
        Field[] sourceFields = source.getClass().getDeclaredFields();
        Field[] targetFields = target.getClass().getDeclaredFields();

        for (Field sourceField : sourceFields) {
            try {
                sourceField.setAccessible(true);
                Object sourceValue = sourceField.get(source);

                for (Field targetField : targetFields) {
                    if (targetField.getName().equals(sourceField.getName())) {
                        targetField.setAccessible(true);
                        Object targetValue = targetField.get(target);
                        if (sourceValue != null) {
                            targetField.set(target, sourceValue);
                        } else if (targetValue == null) {
                            // Preserve existing null values in target
                            targetField.set(target, null);
                        }
                    }
                }
            }catch (IllegalAccessException ex){
                ex.printStackTrace();
            }

        }
    }
}
