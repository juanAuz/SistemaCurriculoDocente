package modelo;

import java.io.Serializable;
import java.time.LocalDate;

import modelo.enums.EstadoCivil;
import modelo.enums.TipoSangre;

public class Persona implements Serializable{
    private static final long serialVersionUID = 1L;

    private String nombres;
    private LocalDate fechaNacimiento;
    private String cedula;
    private String nacionalidad;
    private EstadoCivil estadoCivil;
    private TipoSangre tipoSangre;
    private String lugarNacimiento;
    private String direccion;
    private String numCelular;
    private String numConvencional;
    private String correoElectronico;
    // Constructor vacío
    public Persona() {}
    //constructor con parametros
    public Persona(String nombres, LocalDate fechaNacimiento, String cedula, String nacionalidad,
            EstadoCivil estadoCivil, TipoSangre tipoSangre, String lugarNacimiento, String direccion, String numCelular,
            String numConvencional, String correoElectronico) {
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.cedula = cedula;
        this.nacionalidad = nacionalidad;
        this.estadoCivil = estadoCivil;
        this.tipoSangre = tipoSangre;
        this.lugarNacimiento = lugarNacimiento;
        this.direccion = direccion;
        this.numCelular = numCelular;
        this.numConvencional = numConvencional;
        this.correoElectronico = correoElectronico;
    }
    // Getters y setters
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }
    public TipoSangre getTipoSangre() {
        return tipoSangre;
    }
    public String getLugarNacimiento() {
        return lugarNacimiento;
    }
    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNumCelular() {
        return numCelular;
    }
    public void setNumCelular(String numCelular) {
        this.numCelular = numCelular;
    }
    public String getNumConvencional() {
        return numConvencional;
    }
    public void setNumConvencional(String numConvencional) {
        this.numConvencional = numConvencional;
    }
    public String getCorreoElectronico() {
        return correoElectronico;
    }
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
    
}