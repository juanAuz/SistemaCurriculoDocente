package modelo.capacitacion;

import java.time.LocalDate;

public abstract class Capacitacion {
    // Atributos protegidos para que las hijas accedan fácilmente
    protected String tema;
    protected String institucion;
    protected LocalDate fechaInicio;
    protected LocalDate fechaFin;
    protected int numeroHoras;

    // Constructor
    public Capacitacion(String tema, String institucion, LocalDate fechaInicio, LocalDate fechaFin, int numeroHoras) {
        this.tema = tema;
        this.institucion = institucion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numeroHoras = numeroHoras;
    }

    // Método abstracto: Obliga a las hijas a implementarlo
    public abstract String getTipo();

    // Getters y Setters (Encapsulamiento)
    public String getTema() { return tema; }
    public void setTema(String tema) { this.tema = tema; }

    public String getInstitucion() { return institucion; }
    public void setInstitucion(String institucion) { this.institucion = institucion; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    
    public int getNumeroHoras() { return numeroHoras; }
    public void setNumeroHoras(int numeroHoras) { this.numeroHoras = numeroHoras; }
}
