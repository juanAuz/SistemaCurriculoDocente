package util;

import modelo.Docente;

public class SistemaDocente {
    private static SistemaDocente instancia;
    private Docente docente;
    
    private SistemaDocente() {
        docente = new Docente();
    }
    
    public static SistemaDocente getInstancia() {
        if (instancia == null) {
            instancia = new SistemaDocente();
        }
        return instancia;
    }
    
    public Docente getDocente() {
        return docente;
    }
    
    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}