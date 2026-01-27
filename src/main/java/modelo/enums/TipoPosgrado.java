package modelo.enums;

public enum TipoPosgrado {
    MAESTRIA("Maestría"),
    DOCTORADO("Doctorado"),
    POSDOCTORADO("Posdoctorado");
    
    private String nombre;
    
    TipoPosgrado(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}