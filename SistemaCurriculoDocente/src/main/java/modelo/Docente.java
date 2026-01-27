package modelo;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import modelo.capacitacion.Capacitacion;
import modelo.experiencia.Experiencia;
import modelo.formacion.Formacion;
import modelo.produccion.Investigacion;
import modelo.produccion.Publicacion;

public class Docente extends Persona{
    private static final long serialVersionUID = 1L;
    
    private transient ObservableList<Formacion> titulos;
    private transient ObservableList<Experiencia> experiencia;
    private transient ObservableList<Capacitacion> capacitaciones;
    private transient ObservableList<Investigacion> investigaciones;
    private transient ObservableList<Publicacion> publicaciones;

    private List<Formacion> titulosSerializable;
    private List<Experiencia> experienciaSerializable;
    private List<Capacitacion> capacitacionesSerializable;
    private List<Investigacion> investigacionesSerializable;
    private List<Publicacion> publicacionesSerializable;
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

    public ObservableList<Investigacion> getInvestigaciones() {
        return investigaciones;
    }

    public List<Investigacion> getInvestigacionesGuardar(){
        return new ArrayList<>(investigaciones);
    }
    public void setInvestigacionesCargar(List<Investigacion> investigaciones){
        this.investigaciones = FXCollections.observableArrayList(investigaciones);
    }

    public ObservableList<Publicacion> getPublicaciones() {
        return publicaciones;
    }
    
    public List<Publicacion> getPublicacionesGuardar(){
        return new ArrayList<>(publicaciones);
    }
    public void setPublicacionesCargar(List<Publicacion> publicaciones){
        this.publicaciones = FXCollections.observableArrayList(publicaciones);
    }

    public List<Formacion> getTitulosSerializable() {
        return titulosSerializable;
    }

    public void setTitulosSerializable(List<Formacion> titulosSerializable) {
        this.titulosSerializable = titulosSerializable;
    }

    public List<Experiencia> getExperienciaSerializable() {
        return experienciaSerializable;
    }

    public void setExperienciaSerializable(List<Experiencia> experienciaSerializable) {
        this.experienciaSerializable = experienciaSerializable;
    }

    public List<Capacitacion> getCapacitacionesSerializable() {
        return capacitacionesSerializable;
    }

    public void setCapacitacionesSerializable(List<Capacitacion> capacitacionesSerializable) {
        this.capacitacionesSerializable = capacitacionesSerializable;
    }

    public List<Investigacion> getInvestigacionesSerializable() {
        return investigacionesSerializable;
    }

    public void setInvestigacionesSerializable(List<Investigacion> investigacionesSerializable) {
        this.investigacionesSerializable = investigacionesSerializable;
    }

    public List<Publicacion> getPublicacionesSerializable() {
        return publicacionesSerializable;
    }

    public void setPublicacionesSerializable(List<Publicacion> publicacionesSerializable) {
        this.publicacionesSerializable = publicacionesSerializable;
    }
    
}