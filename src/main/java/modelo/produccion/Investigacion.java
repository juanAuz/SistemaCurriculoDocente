package modelo.produccion;

import java.io.Serializable;

public class Investigacion implements Serializable {
    private static final long serialVersionUID = 1L;

    // Atributos basados en tus TextFields de la izquierda
    private String titulo;
    private String institucion;
    private Integer anio; // Usamos Integer para manejar años (o null si está vacío)

    // Constructor vacío (útil para algunas operaciones)
    public Investigacion() {
    }

    // Constructor con parámetros para crear nuevas fácilmente
    public Investigacion(String titulo, String institucion, Integer anio) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.anio = anio;
    }

    // Getters y Setters (Obligatorios para que la Tabla funcione)
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getInstitucion() { return institucion; }
    public void setInstitucion(String institucion) { this.institucion = institucion; }
    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }

    // toString opcional para depuración
    @Override
    public String toString() {
        return titulo;
    }
}