package properties;

public enum PropertiesNames {
	CONFIG_DIR("config.dir");
	private final String propertyName;

    PropertiesNames(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getValue() {
        return System.getProperty(propertyName);
    }

    public void setValue(String value) {
        System.setProperty(propertyName, value);
    }

    @Override
    public String toString() {
        return propertyName;
    }

}
