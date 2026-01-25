package modelo.formacion;

import modelo.enums.TipoPosgrado;

public class FormacionCuartoNivel extends Formacion{
    private TipoPosgrado tipoPosgrado;
    public FormacionCuartoNivel() {
        super();
    }
    @Override
    public String getNivel() {
        return "Cuarto nivel (" + tipoPosgrado + ") ";
    }
    public TipoPosgrado getTipoPosgrado() {
        return tipoPosgrado;
    }
}
