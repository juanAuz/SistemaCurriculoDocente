package modelo.formacion;
import java.io.Serializable;
import java.time.LocalDate;
public abstract class Formacion implements Serializable{
    private static final long serialVersionUID = 1L;

    private String titulo;
    private String Universidad;
    private String ciudad;
    private LocalDate fechaObtencion;

    public Formacion() {}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUniversidad() {
        return Universidad;
    }

    public void setUniversidad(String universidad) {
        Universidad = universidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getFechaObtencion() {
        return fechaObtencion;
    }

    public void setFechaObtencion(LocalDate fechaObtencion) {
        this.fechaObtencion = fechaObtencion;
    }
    public abstract String getNivel();    
}
