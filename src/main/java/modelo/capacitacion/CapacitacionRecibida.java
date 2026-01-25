package modelo.capacitacion;

import java.time.LocalDate;

public class CapacitacionRecibida extends Capacitacion {
    // Atributo específico de esta clase
    private String estado; // Ej: "Aprobado", "Asistido"

    public CapacitacionRecibida(String tema, String institucion, LocalDate fechaInicio, LocalDate fechaFin, int numeroHoras, String estado) {
        // 'super' llama al constructor del padre (Reutilización de código)
        super(tema, institucion, fechaInicio, fechaFin, numeroHoras);
        this.estado = estado;
    }

    @Override
    public String getTipo() {
        return "Recibida";
    }

    // Getters y Setters específicos
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    
    // toString para pruebas rápidas
    @Override
    public String toString() {
        return super.getTema() + " (Recibida - " + estado + ")";
    }
    @Override
    public String getDetalle() {
        // Aquí devolvemos el atributo único de esta clase
        return "Estado: " + this.estado; 
    }
}
