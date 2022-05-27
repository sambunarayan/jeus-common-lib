package jp.co.jeus.commons.prop;

import jp.co.jeus.commons.enums.PropertyAnnotation;

@PropertyAnnotation(bundle = "")
public class TestSettingsProperty extends AbstractProperty {
    static {
        setBundle(TestSettingsProperty.class);
    }

    public enum Keys {

        SAMPLE(""),
        ;

        private String value;

        private Keys(String value) {
            this.value = value;
        }

        public String get() {
            return this.value;
        }
    }

    public String get(Keys key) {
        return get(TestSettingsProperty.class, key.get());
    }
}
