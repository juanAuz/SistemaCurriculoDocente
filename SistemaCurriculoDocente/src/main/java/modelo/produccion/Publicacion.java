package modelo.produccion;

import java.io.Serializable;

public class Publicacion implements Serializable {
    private static final long serialVersionUID = 1L;

    // Atributos basados en tus TextFields de la derecha (Imagen 1)
    private String titulo;
    private String editorial;
    private Integer anio;

    public Publicacion() {
    }

    public Publicacion(String titulo, String editorial, Integer anio) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.anio = anio;
    }

    // Getters y Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getEditorial() { return editorial; }
    public void setEditorial(String editorial) { this.editorial = editorial; }
    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }
}