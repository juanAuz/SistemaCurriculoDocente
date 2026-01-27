package modelo.enums;

public enum EstadoCivil {
    SOLTERO("Soltero"),
    CASADO("Casado"),
    UNION_LIBRE("Unión libre"),
    DIVORCIADO("Divorciado"),
    VIUDO("Viudo");
    private final String label;

    EstadoCivil(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }
}
