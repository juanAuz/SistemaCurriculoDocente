package modelo;

import java.util.ArrayList;
import java.util.List;

public class Docente extends Persona {
    // TODO: Persona 1 completará los métodos
    
    private List<Object> titulos = new ArrayList<>();
    private List<Object> experiencias = new ArrayList<>();
    private List<Object> capacitaciones = new ArrayList<>();
    private List<Object> investigaciones = new ArrayList<>();
    private List<Object> publicaciones = new ArrayList<>();
    
    public Docente() {
        super();
    }
    
    public void agregarTitulo(Object titulo) {
        titulos.add(titulo);
    }
    
    public List<Object> getTitulos() {
        return titulos;
    }
    
    // TODO: Métodos similares para experiencias, capacitaciones, etc.
}