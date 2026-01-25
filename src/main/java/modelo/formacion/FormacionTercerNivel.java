package modelo.formacion;

public class FormacionTercerNivel extends Formacion{
    private String carrera;
    @Override
    public String getNivel() {
        return "Tercer nivel - Ingenieria/Licenciatura";
    }
    public FormacionTercerNivel() {
    super();
    }
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
}
