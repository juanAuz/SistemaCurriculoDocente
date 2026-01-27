package modelo.enums;

public enum TipoSangre {
    A_mas("A+"),
    A_menos("A-"),
    B_mas("B+"),
    B_menos("B-"),
    AB_mas("AB+"),
    AB_menos("AB-"),
    o_mas("O+"),
    o_menos("O-");
    private String label;

    private TipoSangre(String label) {
        this.label = label;
    }
    @Override
    public String toString() {
        return label;
    }
}
