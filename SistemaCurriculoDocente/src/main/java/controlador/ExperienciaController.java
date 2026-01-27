package controlador;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import modelo.experiencia.Experiencia;
import modelo.experiencia.ExperienciaDocente;
import modelo.experiencia.ExperienciaNoDocente;
import util.SistemaDocente;


public class ExperienciaController implements Initializable {


    @FXML private TextField txtInstitucion;
    @FXML private TextField txtCatedra;
    @FXML private TextField txtFuncion;
    @FXML private DatePicker dpDesde;
    @FXML private DatePicker dpHasta;
    @FXML private ComboBox<String> cbTipo;
    @FXML private Label lblEstado;

 
    @FXML private TableView<Experiencia> tblExperiencia;
    @FXML private TableColumn<Experiencia, String> colInstitucion;
    @FXML private TableColumn<Experiencia, String> colDesde;
    @FXML private TableColumn<Experiencia, String> colHasta;
    @FXML private TableColumn<Experiencia, String> colTipo;
    @FXML private TableColumn<Experiencia, String> colDetalle;

    private ObservableList<Experiencia> listaExperiencias;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cbTipo.getItems().addAll("Docente", "No Docente");

       
        listaExperiencias =
            SistemaDocente.getInstancia()
                .getDocente()
                .getExperiencia();

        tblExperiencia.setItems(listaExperiencias);

        colInstitucion.setCellValueFactory(
            d -> new SimpleStringProperty(d.getValue().getInstitucion())
        );

        colDesde.setCellValueFactory(
            d -> new SimpleStringProperty(d.getValue().getFechaDesde().toString())
        );

        colHasta.setCellValueFactory(
            d -> new SimpleStringProperty(d.getValue().getFechaHasta().toString())
        );

        colTipo.setCellValueFactory(d -> {
            return new SimpleStringProperty(
                d.getValue() instanceof ExperienciaDocente ? "Docente" : "No Docente"
            );
        });

        colDetalle.setCellValueFactory(d -> {
            if (d.getValue() instanceof ExperienciaDocente ed)
                return new SimpleStringProperty(ed.getCatedra());
            if (d.getValue() instanceof ExperienciaNoDocente end)
                return new SimpleStringProperty(end.getFuncion());
            return new SimpleStringProperty("");
        });

        ocultarCampos();
        limpiarMensaje();
    }


    @FXML
    void agregarExperiencia(ActionEvent event) {

        if (!validarCampos()) return;

        Experiencia exp;

        if ("Docente".equals(cbTipo.getValue())) {
            exp = new ExperienciaDocente(
                txtInstitucion.getText(),
                dpDesde.getValue(),
                dpHasta.getValue(),
                txtCatedra.getText()
            );
        } else {
            exp = new ExperienciaNoDocente(
                txtInstitucion.getText(),
                dpDesde.getValue(),
                dpHasta.getValue(),
                txtFuncion.getText()
            );
        }

      
        listaExperiencias.add(exp);

        limpiarFormulario();
        mostrarAceptado("Experiencia agregada correctamente");
    }

  
    @FXML
    void eliminarExperiencia(ActionEvent event) {

        Experiencia seleccionada =
            tblExperiencia.getSelectionModel().getSelectedItem();

        if (seleccionada == null) {
            mostrarRechazado("Seleccione una experiencia");
            return;
        }

        listaExperiencias.remove(seleccionada);
        mostrarAceptado("Experiencia eliminada");
    }

 
    @FXML
    void editarExperiencia(ActionEvent event) {

        Experiencia seleccionada =
            tblExperiencia.getSelectionModel().getSelectedItem();

        if (seleccionada == null) {
            mostrarRechazado("Seleccione una experiencia");
            return;
        }

        txtInstitucion.setText(seleccionada.getInstitucion());
        dpDesde.setValue(seleccionada.getFechaDesde());
        dpHasta.setValue(seleccionada.getFechaHasta());

        listaExperiencias.remove(seleccionada);

        mostrarAceptado("Edite los datos y presione Agregar");
    }

   
    private boolean validarCampos() {

        if (txtInstitucion.getText().isBlank()) {
            mostrarRechazado("Institución obligatoria");
            return false;
        }

        if (dpDesde.getValue() == null || dpHasta.getValue() == null) {
            mostrarRechazado("Fechas obligatorias");
            return false;
        }

        if (dpHasta.getValue().isBefore(dpDesde.getValue())) {
            mostrarRechazado("Fecha hasta incorrecta");
            return false;
        }

        if (cbTipo.getValue() == null) {
            mostrarRechazado("Seleccione tipo");
            return false;
        }

        if ("Docente".equals(cbTipo.getValue()) && txtCatedra.getText().isBlank()) {
            mostrarRechazado("Cátedra obligatoria");
            return false;
        }

        if ("No Docente".equals(cbTipo.getValue()) && txtFuncion.getText().isBlank()) {
            mostrarRechazado("Función obligatoria");
            return false;
        }

        return true;
    }

   
    private void ocultarCampos() {
        txtCatedra.setVisible(false);
        txtFuncion.setVisible(false);

        cbTipo.setOnAction(e -> {
            boolean docente = "Docente".equals(cbTipo.getValue());
            txtCatedra.setVisible(docente);
            txtFuncion.setVisible(!docente);
        });
    }

    private void limpiarFormulario() {
        txtInstitucion.clear();
        txtCatedra.clear();
        txtFuncion.clear();
        dpDesde.setValue(null);
        dpHasta.setValue(null);
        cbTipo.setValue(null);
    }

    private void limpiarMensaje() {
        lblEstado.setText("");
        lblEstado.getStyleClass().clear();
    }

    private void mostrarAceptado(String msg) {
        lblEstado.setText(msg);
        lblEstado.getStyleClass().setAll("font-aceptado");
    }

    private void mostrarRechazado(String msg) {
        lblEstado.setText(msg);
        lblEstado.getStyleClass().setAll("font-rechazado");
    }
}

