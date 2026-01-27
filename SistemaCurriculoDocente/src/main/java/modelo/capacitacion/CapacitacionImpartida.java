package modelo.capacitacion;

import java.time.LocalDate;

public class CapacitacionImpartida extends Capacitacion {
    // Atributo específico
    private String publicoDirigido; // Ej: "Estudiantes", "Profesionales"

    public CapacitacionImpartida(String tema, String institucion, LocalDate fechaInicio, LocalDate fechaFin, int numeroHoras, String publicoDirigido) {
        super(tema, institucion, fechaInicio, fechaFin, numeroHoras);
        this.publicoDirigido = publicoDirigido;
    }

    @Override
    public String getTipo() {
        return "Impartida";
    }

    // Getters y Setters específicos
    public String getPublicoDirigido() { return publicoDirigido; }
    public void setPublicoDirigido(String publicoDirigido) { this.publicoDirigido = publicoDirigido; }

    @Override
    public String toString() {
        return super.getTema() + " (Dictada a: " + publicoDirigido + ")";
    }

    @Override
    public String getDetalle() {
        // Aquí devolvemos el atributo único de la otra clase
        return "Público: " + this.publicoDirigido;
    }
}
