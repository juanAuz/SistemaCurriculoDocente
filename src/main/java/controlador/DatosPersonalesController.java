package controlador;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Docente;
import modelo.enums.EstadoCivil;
import modelo.enums.TipoSangre;
import persistencia.DocentePersistencia;
import util.NavegacionUtil;
import util.SistemaDocente;
public class DatosPersonalesController implements Initializable{
     @FXML
    private ComboBox<EstadoCivil> cmbEstadoCivil;

    @FXML
    private ComboBox<TipoSangre> cmbTipoSangre;

    @FXML
    private DatePicker dpFechaNacimiento;

    @FXML
    private Label lblEstado;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtCorreoElectronico;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtLugarNacimiento;

    @FXML
    private TextField txtNacionalidad;

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtNumCelular;

    @FXML
    private TextField txtNumConvencional;

    private Docente docente; //creamos el objeto docente que va a apuntar al docente instanciado en SistemaDociente
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        docente = SistemaDocente.getInstancia().getDocente();
        cargarCombos();
        cargarDatosFormulario(docente);
        lblEstado.setText("");
        lblEstado.getStyleClass().clear();
    }
    
    @FXML
    void guardarDatosPersonales(ActionEvent event) {
        List<String> listaErrores = validarCampos();
        if (!listaErrores.isEmpty()) {
            mostrarError(listaErrores);
            return;
        }
        guardarDatosDocente();
        mostrarExito();
    }
    private void cargarCombos() {
        cmbEstadoCivil.getItems().setAll(EstadoCivil.values());
        cmbTipoSangre.getItems().setAll(TipoSangre.values());
    }
    private void cargarDatosFormulario(Docente docente) {
        txtCedula.setText(docente.getCedula());
        txtNombres.setText(docente.getNombres());
        txtCorreoElectronico.setText(docente.getCorreoElectronico());
        txtDireccion.setText(docente.getDireccion());
        txtLugarNacimiento.setText(docente.getLugarNacimiento());
        txtNacionalidad.setText(docente.getNacionalidad());
        txtNumCelular.setText(docente.getNumCelular());
        txtNumConvencional.setText(docente.getNumConvencional());
        cmbEstadoCivil.setValue(docente.getEstadoCivil());
        cmbTipoSangre.setValue(docente.getTipoSangre());
        dpFechaNacimiento.setValue(docente.getFechaNacimiento());
    }
    private void guardarDatosDocente() {
        docente.setCedula(txtCedula.getText());
        docente.setNombres(txtNombres.getText());
        docente.setCorreoElectronico(txtCorreoElectronico.getText());
        docente.setDireccion(txtDireccion.getText());
        docente.setLugarNacimiento(txtLugarNacimiento.getText());
        docente.setNacionalidad(txtNacionalidad.getText());
        docente.setNumCelular(txtNumCelular.getText());
        docente.setNumConvencional(txtNumConvencional.getText());
        docente.setEstadoCivil(cmbEstadoCivil.getValue());
        docente.setTipoSangre(cmbTipoSangre.getValue());
        docente.setFechaNacimiento(dpFechaNacimiento.getValue());
    }
    private List<String> validarCampos(){
        List<String> listaErrores = new ArrayList<>();
        if(estaVacioTf(txtNombres)){
            listaErrores.add("Nombres obligatorios");
        }
        if(estaVacioTf(txtCedula)){
            listaErrores.add("Cedula obligatoria");
        }else if(esCedulaInvalida(txtCedula)){
            listaErrores.add("La cedula ingresada no es válida");
        }
        if(estaVacioTf(txtCorreoElectronico)){
            listaErrores.add("Correo electrónico obligatorio");
        }else if(esCorreoInvalido(txtCorreoElectronico)){
            listaErrores.add("Correo electronico invalido");
        }
        if(estaVacioTf(txtDireccion)){
            listaErrores.add("Dirección obligatoria");
        }
        if(estaVacioTf(txtLugarNacimiento)){
            listaErrores.add("Lugar de nacimiento obligatorio");
        }
        if(estaVacioTf(txtNacionalidad)){
            listaErrores.add("Nacionalidad obligatoria");
        }
        if(estaVacioTf(txtNumCelular) && estaVacioTf(txtNumConvencional)) {
            listaErrores.add("Al menos un número de contacto obligatorio");
        } else {
            if(!esSoloNumeros(txtNumCelular) && !estaVacioTf(txtNumCelular)) {
                listaErrores.add("Número telefónico de celular ingresado no válido");
            }
            if(!esSoloNumeros(txtNumConvencional) && !estaVacioTf(txtNumConvencional)) {
                listaErrores.add("Número telefónico convencional ingresado no válido");
            }
        }

        if(estaVacioCmb(cmbEstadoCivil)){
            listaErrores.add("Estado civil obligatorio");
        }
        if(estaVacioCmb(cmbTipoSangre)){
            listaErrores.add("Tipo de sangre obligatorio");
        }
        if (estaVacioDp(dpFechaNacimiento)) {
            listaErrores.add("fecha de nacimiento obligatoria");
        }
        return listaErrores;
    }
    private boolean esSoloNumeros(TextField tfNumeros){
        if(!estaVacioTf(tfNumeros)) return tfNumeros.getText().matches("\\d+");
        else return true;
    }
    private boolean esCedulaInvalida(TextField cedula){
        return cedula.getText().length() != 10 || !esSoloNumeros(cedula);
    }
    private boolean esCorreoInvalido(TextField correo){
        return !correo.getText().matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
    private boolean estaVacioTf(TextField tf){
        return tf.getText() == null || tf.getText().trim().isEmpty();
    }
    private boolean estaVacioCmb(ComboBox<?> cmb){
        return cmb.getValue()==null;
    }
    private boolean estaVacioDp(DatePicker dp){
        return dp.getValue()==null;
    }
    private void mostrarError(List<String> listaErrores){
        lblEstado.setText(String.join("\n", listaErrores));
        lblEstado.getStyleClass().setAll("font-rechazado");
    }
    private void mostrarExito(){
        lblEstado.setText("Datos guardados correctamente");
        lblEstado.getStyleClass().setAll("font-aceptado");
    }
    @FXML
    void regresarMainScreen(ActionEvent event) {
        NavegacionUtil.cambiarEscena(event, "/fxml/MainScreen.fxml");
    }


}

