package modelo.formacion;

public class FormacionSegundoNivel extends Formacion{
    private String tecnologia;
    public FormacionSegundoNivel(){
        super();
    }
    
    @Override
    public String getNivel() {
        return "Segundo nivel - Tecnologia";
        
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }
    
}
