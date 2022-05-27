package jp.co.jeus.commons.prop;

import jp.co.jeus.commons.enums.PropertyAnnotation;

import java.lang.annotation.Annotation;
import java.util.*;

public abstract class AbstractProperty {

    private static final Map<Class<? extends AbstractProperty>, ResourceBundle> PROP_HOLDER = new HashMap<>();

    protected static void setBundle(Class<? extends AbstractProperty> clazz) {
        for (Annotation anno : clazz.getAnnotations()) {
            if (anno instanceof PropertyAnnotation) {
                Properties pro = new Properties();
                PropertyAnnotation propAnno = clazz.getAnnotation(PropertyAnnotation.class);
                if (propAnno == null) {
                    return;
                }
                PROP_HOLDER.put(clazz, PropertyResourceBundle.getBundle(propAnno.bundle()));
            }
        }
    }

    protected static String get(Class<? extends AbstractProperty> clazz, String key) {
        return PROP_HOLDER.get(clazz).getString(key);
    }
}
