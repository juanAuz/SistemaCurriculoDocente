package modelo;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.capacitacion.Capacitacion;
import modelo.experiencia.Experiencia;
import modelo.formacion.Formacion;
import modelo.produccion.ProduccionAcademica;

public class Docente extends Persona{
    private static final long serialVersionUID = 1L;
    
    private transient ObservableList<Formacion> titulos;
    private transient ObservableList<Experiencia> experiencia;
    private transient ObservableList<Capacitacion> capacitaciones;
    private transient ObservableList<ProduccionAcademica> investigaciones;
    private transient ObservableList<ProduccionAcademica> publicaciones;

    public Docente() {
        super();
        this.titulos = FXCollections.observableArrayList();
        this.experiencia = FXCollections.observableArrayList();
        this.capacitaciones = FXCollections.observableArrayList();
        this.investigaciones = FXCollections.observableArrayList();
        this.publicaciones = FXCollections.observableArrayList();
    }

    public ObservableList<Formacion> getTitulos() {
        return titulos;
    }

    public List<Formacion> getTituloGuardar(){
        return new ArrayList<>(titulos);
    }
    public void setTitulosCargar(List<Formacion> titulos){
        this.titulos = FXCollections.observableArrayList(titulos);
    }
    public ObservableList<Experiencia> getExperiencia() {
        return experiencia;
    }

    public List<Experiencia> getExperienciaGuardar(){
        return new ArrayList<>(experiencia);
    }
    public void setExperienciaCargar(List<Experiencia> experiencia){
        this.experiencia = FXCollections.observableArrayList(experiencia);
    }
    public ObservableList<Capacitacion> getCapacitaciones() {
        return capacitaciones;
    }

    public List<Capacitacion> getCapacitacionesGuardar(){
        return new ArrayList<>(capacitaciones);
    }
    public void setCapacitacionesCargar(List<Capacitacion> capacitaciones){
        this.capacitaciones = FXCollections.observableArrayList(capacitaciones);
    }

    public ObservableList<ProduccionAcademica> getInvestigaciones() {
        return investigaciones;
    }

    public List<ProduccionAcademica> getInvestigacionesGuardar(){
        return new ArrayList<>(investigaciones);
    }
    public void setInvestigacionesCargar(List<ProduccionAcademica> investigaciones){
        this.investigaciones = FXCollections.observableArrayList(investigaciones);
    }

    public ObservableList<ProduccionAcademica> getPublicaciones() {
        return publicaciones;
    }
    
    public List<ProduccionAcademica> getPublicacionesGuardar(){
        return new ArrayList<>(publicaciones);
    }
    public void setPublicacionesCargar(List<ProduccionAcademica> publicaciones){
        this.publicaciones = FXCollections.observableArrayList(publicaciones);
    }
}