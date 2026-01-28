package controlador;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Docente;
import modelo.formacion.Formacion;
import modelo.formacion.FormacionSegundoNivel;
import modelo.formacion.FormacionTercerNivel;
import modelo.formacion.FormacionCuartoNivel;
import modelo.enums.TipoPosgrado;
import util.NavegacionUtil;
import util.SistemaDocente;

public class FormacionController implements Initializable {
    
    // ComboBox
    @FXML
    private ComboBox<TipoPosgrado> cmbTipoTituloCuart;
    
    // TableColumns - Segundo Nivel
    @FXML
    private TableColumn<FormacionSegundoNivel, String> colCiudadSeg;
    @FXML
    private TableColumn<FormacionSegundoNivel, LocalDate> colFechaGradoSeg;
    @FXML
    private TableColumn<FormacionSegundoNivel, String> colTituloSeg;
    @FXML
    private TableColumn<FormacionSegundoNivel, String> colUniversidadSeg;
    
    // TableColumns - Tercer Nivel
    @FXML
    private TableColumn<FormacionTercerNivel, String> colCiudadTer;
    @FXML
    private TableColumn<FormacionTercerNivel, LocalDate> colFechaGradoTer;
    @FXML
    private TableColumn<FormacionTercerNivel, String> colTituloTer;
    @FXML
    private TableColumn<FormacionTercerNivel, String> colUniversidadTer;
    
    // TableColumns - Cuarto Nivel
    @FXML
    private TableColumn<FormacionCuartoNivel, String> colCiudadCuart;
    @FXML
    private TableColumn<FormacionCuartoNivel, LocalDate> colFechaGradoCuart;
    @FXML
    private TableColumn<FormacionCuartoNivel, String> colTituloCuart;
    @FXML
    private TableColumn<FormacionCuartoNivel, String> colUniversidadCuart;
    
    // DatePickers
    @FXML
    private DatePicker dpFechaGradoCuart;
    @FXML
    private DatePicker dpFechaGradoSeg;
    @FXML
    private DatePicker dpFechaGradoTer;
    
    // Labels
    @FXML
    private Label lblEstadoCuart;
    @FXML
    private Label lblEstadoSeg;
    @FXML
    private Label lblEstadoTer;
    
    // TableViews
    @FXML
    private TableView<FormacionSegundoNivel> tbvSegundoNivel;
    @FXML
    private TableView<FormacionTercerNivel> tbvTercerNivel;
    @FXML
    private TableView<FormacionCuartoNivel> tbvCuartoNivel;
    
    // TextFields - Segundo Nivel
    @FXML
    private TextField txtCiudadSeg;
    @FXML
    private TextField txtTituloSeg;
    @FXML
    private TextField txtUniversidadSeg;
    
    // TextFields - Tercer Nivel
    @FXML
    private TextField txtCiudadTer;
    @FXML
    private TextField txtTituloTer;
    @FXML
    private TextField txtUniversidadTer;
    
    // TextFields - Cuarto Nivel
    @FXML
    private TextField txtCiudadCuart;
    @FXML
    private TextField txtTituloCuart;
    @FXML
    private TextField txtUniversidadCuart;
    
    private Docente docente;
    private FormacionSegundoNivel formacionSeleccionadaSeg;
    private FormacionTercerNivel formacionSeleccionadaTer;
    private FormacionCuartoNivel formacionSeleccionadaCuart;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        docente = SistemaDocente.getInstancia().getDocente();
        
        inicializarTablas();
        cargarCombos();
        configurarSeleccionTablas();
        limpiarLabelsEstado();
        cargarDatosTablas();
    }
    
    private void inicializarTablas() {
        // Configurar columnas Segundo Nivel
        colTituloSeg.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colUniversidadSeg.setCellValueFactory(new PropertyValueFactory<>("universidad"));
        colCiudadSeg.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colFechaGradoSeg.setCellValueFactory(new PropertyValueFactory<>("fechaObtencion"));
        
        // Configurar columnas Tercer Nivel
        colTituloTer.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colUniversidadTer.setCellValueFactory(new PropertyValueFactory<>("universidad"));
        colCiudadTer.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colFechaGradoTer.setCellValueFactory(new PropertyValueFactory<>("fechaObtencion"));
        
        // Configurar columnas Cuarto Nivel
        colTituloCuart.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colUniversidadCuart.setCellValueFactory(new PropertyValueFactory<>("universidad"));
        colCiudadCuart.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colFechaGradoCuart.setCellValueFactory(new PropertyValueFactory<>("fechaObtencion"));
    }
    
    private void cargarDatosTablas() {
        // Limpiar las tablas primero
        tbvSegundoNivel.getItems().clear();
        tbvTercerNivel.getItems().clear();
        tbvCuartoNivel.getItems().clear();
        
        // Filtrar y agregar solo los títulos correspondientes a cada tabla
        for (Formacion formacion : docente.getTitulos()) {
            if (formacion instanceof FormacionSegundoNivel) {
                tbvSegundoNivel.getItems().add((FormacionSegundoNivel) formacion);
            } else if (formacion instanceof FormacionTercerNivel) {
                tbvTercerNivel.getItems().add((FormacionTercerNivel) formacion);
            } else if (formacion instanceof FormacionCuartoNivel) {
                tbvCuartoNivel.getItems().add((FormacionCuartoNivel) formacion);
            }
        }
    }
    
    private void cargarCombos() {
        cmbTipoTituloCuart.getItems().setAll(TipoPosgrado.values());
    }
    
    private void configurarSeleccionTablas() {
        // Segundo Nivel
        tbvSegundoNivel.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                formacionSeleccionadaSeg = newSel;
                cargarDatosFormularioSeg(newSel);
            }
        });
        
        // Tercer Nivel
        tbvTercerNivel.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                formacionSeleccionadaTer = newSel;
                cargarDatosFormularioTer(newSel);
            }
        });
        
        // Cuarto Nivel
        tbvCuartoNivel.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                formacionSeleccionadaCuart = newSel;
                cargarDatosFormularioCuart(newSel);
            }
        });
    }
    
    // ==================== SEGUNDO NIVEL ====================
    
    @FXML
    void guardarFormacionSeg(ActionEvent event) {
        List<String> errores = validarCamposSeg();
        if (!errores.isEmpty()) {
            mostrarErrorSeg(errores);
            return;
        }
        
        FormacionSegundoNivel formacion = new FormacionSegundoNivel();
        formacion.setTitulo(txtTituloSeg.getText().trim());
        formacion.setUniversidad(txtUniversidadSeg.getText().trim());
        formacion.setCiudad(txtCiudadSeg.getText().trim());
        formacion.setFechaObtencion(dpFechaGradoSeg.getValue());
        
        docente.getTitulos().add(formacion);
        tbvSegundoNivel.getItems().add(formacion);
        
        limpiarFormularioSeg();
        mostrarExitoSeg();
    }
    
    @FXML
    void EditarFormacionSeg(ActionEvent event) {
        if (formacionSeleccionadaSeg == null) {
            mostrarErrorSeg(List.of("Seleccione un título de la tabla para editar"));
            return;
        }
        
        List<String> errores = validarCamposSeg();
        if (!errores.isEmpty()) {
            mostrarErrorSeg(errores);
            return;
        }
        
        formacionSeleccionadaSeg.setTitulo(txtTituloSeg.getText().trim());
        formacionSeleccionadaSeg.setUniversidad(txtUniversidadSeg.getText().trim());
        formacionSeleccionadaSeg.setCiudad(txtCiudadSeg.getText().trim());
        formacionSeleccionadaSeg.setFechaObtencion(dpFechaGradoSeg.getValue());
        
        tbvSegundoNivel.refresh();
        limpiarFormularioSeg();
        mostrarExitoSeg();
    }
    
    @FXML
    void eliminarFormacionSeg(ActionEvent event) {
        if (formacionSeleccionadaSeg == null) {
            mostrarErrorSeg(List.of("Seleccione un título de la tabla para eliminar"));
            return;
        }
        
        docente.getTitulos().remove(formacionSeleccionadaSeg);
        tbvSegundoNivel.getItems().remove(formacionSeleccionadaSeg);
        
        limpiarFormularioSeg();
        formacionSeleccionadaSeg = null;
        mostrarExitoSeg();
    }
    
    // ==================== TERCER NIVEL ====================
    
    @FXML
    void guardarFormacionTer(ActionEvent event) {
        List<String> errores = validarCamposTer();
        if (!errores.isEmpty()) {
            mostrarErrorTer(errores);
            return;
        }
        
        FormacionTercerNivel formacion = new FormacionTercerNivel();
        formacion.setTitulo(txtTituloTer.getText().trim());
        formacion.setUniversidad(txtUniversidadTer.getText().trim());
        formacion.setCiudad(txtCiudadTer.getText().trim());
        formacion.setFechaObtencion(dpFechaGradoTer.getValue());
        
        docente.getTitulos().add(formacion);
        tbvTercerNivel.getItems().add(formacion);
        
        limpiarFormularioTer();
        mostrarExitoTer();
    }
    
    @FXML
    void editarFormacionTer(ActionEvent event) {
        if (formacionSeleccionadaTer == null) {
            mostrarErrorTer(List.of("Seleccione un título de la tabla para editar"));
            return;
        }
        
        List<String> errores = validarCamposTer();
        if (!errores.isEmpty()) {
            mostrarErrorTer(errores);
            return;
        }
        
        formacionSeleccionadaTer.setTitulo(txtTituloTer.getText().trim());
        formacionSeleccionadaTer.setUniversidad(txtUniversidadTer.getText().trim());
        formacionSeleccionadaTer.setCiudad(txtCiudadTer.getText().trim());
        formacionSeleccionadaTer.setFechaObtencion(dpFechaGradoTer.getValue());
        
        tbvTercerNivel.refresh();
        limpiarFormularioTer();
        mostrarExitoTer();
    }
    
    @FXML
    void EliminarFormacionTer(ActionEvent event) {
        if (formacionSeleccionadaTer == null) {
            mostrarErrorTer(List.of("Seleccione un título de la tabla para eliminar"));
            return;
        }
        
        docente.getTitulos().remove(formacionSeleccionadaTer);
        tbvTercerNivel.getItems().remove(formacionSeleccionadaTer);
        
        limpiarFormularioTer();
        formacionSeleccionadaTer = null;
        mostrarExitoTer();
    }
    
    // ==================== CUARTO NIVEL ====================
    
    @FXML
    void guardarFormacionCuart(ActionEvent event) {
        List<String> errores = validarCamposCuart();
        if (!errores.isEmpty()) {
            mostrarErrorCuart(errores);
            return;
        }
        
        FormacionCuartoNivel formacion = new FormacionCuartoNivel();
        formacion.setTipoPosgrado(cmbTipoTituloCuart.getValue());
        formacion.setTitulo(txtTituloCuart.getText().trim());
        formacion.setUniversidad(txtUniversidadCuart.getText().trim());
        formacion.setCiudad(txtCiudadCuart.getText().trim());
        formacion.setFechaObtencion(dpFechaGradoCuart.getValue());
        
        docente.getTitulos().add(formacion);
        tbvCuartoNivel.getItems().add(formacion);
        
        limpiarFormularioCuart();
        mostrarExitoCuart();
    }
    
    @FXML
    void editarFormacionCuart(ActionEvent event) {
        if (formacionSeleccionadaCuart == null) {
            mostrarErrorCuart(List.of("Seleccione un título de la tabla para editar"));
            return;
        }
        
        List<String> errores = validarCamposCuart();
        if (!errores.isEmpty()) {
            mostrarErrorCuart(errores);
            return;
        }
        
        formacionSeleccionadaCuart.setTipoPosgrado(cmbTipoTituloCuart.getValue());
        formacionSeleccionadaCuart.setTitulo(txtTituloCuart.getText().trim());
        formacionSeleccionadaCuart.setUniversidad(txtUniversidadCuart.getText().trim());
        formacionSeleccionadaCuart.setCiudad(txtCiudadCuart.getText().trim());
        formacionSeleccionadaCuart.setFechaObtencion(dpFechaGradoCuart.getValue());
        
        tbvCuartoNivel.refresh();
        limpiarFormularioCuart();
        mostrarExitoCuart();
    }
    
    @FXML
    void eliminarFormacionCuart(ActionEvent event) {
        if (formacionSeleccionadaCuart == null) {
            mostrarErrorCuart(List.of("Seleccione un título de la tabla para eliminar"));
            return;
        }
        
        docente.getTitulos().remove(formacionSeleccionadaCuart);
        tbvCuartoNivel.getItems().remove(formacionSeleccionadaCuart);
        
        limpiarFormularioCuart();
        formacionSeleccionadaCuart = null;
        mostrarExitoCuart();
    }
    
    // ==================== VALIDACIONES ====================
    
    private List<String> validarCamposSeg() {
        List<String> errores = new ArrayList<>();
        
        if (estaVacioTf(txtTituloSeg)) {
            errores.add("El título es obligatorio");
        }
        if (estaVacioTf(txtUniversidadSeg)) {
            errores.add("La universidad es obligatoria");
        }
        if (estaVacioTf(txtCiudadSeg)) {
            errores.add("La ciudad es obligatoria");
        }
        if (estaVacioDp(dpFechaGradoSeg)) {
            errores.add("La fecha de grado es obligatoria");
        }
        
        return errores;
    }
    
    private List<String> validarCamposTer() {
        List<String> errores = new ArrayList<>();
        
        if (estaVacioTf(txtTituloTer)) {
            errores.add("El título es obligatorio");
        }
        if (estaVacioTf(txtUniversidadTer)) {
            errores.add("La universidad es obligatoria");
        }
        if (estaVacioTf(txtCiudadTer)) {
            errores.add("La ciudad es obligatoria");
        }
        if (estaVacioDp(dpFechaGradoTer)) {
            errores.add("La fecha de grado es obligatoria");
        }
        
        return errores;
    }
    
    private List<String> validarCamposCuart() {
        List<String> errores = new ArrayList<>();
        
        if (estaVacioCmb(cmbTipoTituloCuart)) {
            errores.add("El tipo de título es obligatorio");
        }
        if (estaVacioTf(txtTituloCuart)) {
            errores.add("El título es obligatorio");
        }
        if (estaVacioTf(txtUniversidadCuart)) {
            errores.add("La universidad es obligatoria");
        }
        if (estaVacioTf(txtCiudadCuart)) {
            errores.add("La ciudad es obligatoria");
        }
        if (estaVacioDp(dpFechaGradoCuart)) {
            errores.add("La fecha de grado es obligatoria");
        }
        
        return errores;
    }
    
    // ==================== MÉTODOS AUXILIARES ====================
    
    private boolean estaVacioTf(TextField tf) {
        return tf.getText() == null || tf.getText().trim().isEmpty();
    }
    
    private boolean estaVacioCmb(ComboBox<?> cmb) {
        return cmb.getValue() == null;
    }
    
    private boolean estaVacioDp(DatePicker dp) {
        return dp.getValue() == null;
    }
    
    // ==================== CARGAR DATOS EN FORMULARIOS ====================
    
    private void cargarDatosFormularioSeg(FormacionSegundoNivel formacion) {
        txtTituloSeg.setText(formacion.getTitulo());
        txtUniversidadSeg.setText(formacion.getUniversidad());
        txtCiudadSeg.setText(formacion.getCiudad());
        dpFechaGradoSeg.setValue(formacion.getFechaObtencion());
    }
    
    private void cargarDatosFormularioTer(FormacionTercerNivel formacion) {
        txtTituloTer.setText(formacion.getTitulo());
        txtUniversidadTer.setText(formacion.getUniversidad());
        txtCiudadTer.setText(formacion.getCiudad());
        dpFechaGradoTer.setValue(formacion.getFechaObtencion());
    }
    
    private void cargarDatosFormularioCuart(FormacionCuartoNivel formacion) {
        cmbTipoTituloCuart.setValue(formacion.getTipoPosgrado());
        txtTituloCuart.setText(formacion.getTitulo());
        txtUniversidadCuart.setText(formacion.getUniversidad());
        txtCiudadCuart.setText(formacion.getCiudad());
        dpFechaGradoCuart.setValue(formacion.getFechaObtencion());
    }
    
    // ==================== LIMPIAR FORMULARIOS ====================
    
    private void limpiarFormularioSeg() {
        txtTituloSeg.clear();
        txtUniversidadSeg.clear();
        txtCiudadSeg.clear();
        dpFechaGradoSeg.setValue(null);
        tbvSegundoNivel.getSelectionModel().clearSelection();
        formacionSeleccionadaSeg = null;
        limpiarLabelEstadoSeg();
    }
    
    private void limpiarFormularioTer() {
        txtTituloTer.clear();
        txtUniversidadTer.clear();
        txtCiudadTer.clear();
        dpFechaGradoTer.setValue(null);
        tbvTercerNivel.getSelectionModel().clearSelection();
        formacionSeleccionadaTer = null;
        limpiarLabelEstadoTer();
    }
    
    private void limpiarFormularioCuart() {
        cmbTipoTituloCuart.setValue(null);
        txtTituloCuart.clear();
        txtUniversidadCuart.clear();
        txtCiudadCuart.clear();
        dpFechaGradoCuart.setValue(null);
        tbvCuartoNivel.getSelectionModel().clearSelection();
        formacionSeleccionadaCuart = null;
        limpiarLabelEstadoCuart();
    }
    
    // ==================== MOSTRAR MENSAJES ====================
    
    private void mostrarErrorSeg(List<String> errores) {
        lblEstadoSeg.setText(String.join("\n", errores));
        lblEstadoSeg.getStyleClass().setAll("font-rechazado");
    }
    
    private void mostrarExitoSeg() {
        lblEstadoSeg.setText("Operación realizada correctamente");
        lblEstadoSeg.getStyleClass().setAll("font-aceptado");
    }
    
    private void mostrarErrorTer(List<String> errores) {
        lblEstadoTer.setText(String.join("\n", errores));
        lblEstadoTer.getStyleClass().setAll("font-rechazado");
    }
    
    private void mostrarExitoTer() {
        lblEstadoTer.setText("Operación realizada correctamente");
        lblEstadoTer.getStyleClass().setAll("font-aceptado");
    }
    
    private void mostrarErrorCuart(List<String> errores) {
        lblEstadoCuart.setText(String.join("\n", errores));
        lblEstadoCuart.getStyleClass().setAll("font-rechazado");
    }
    
    private void mostrarExitoCuart() {
        lblEstadoCuart.setText("Operación realizada correctamente");
        lblEstadoCuart.getStyleClass().setAll("font-aceptado");
    }
    
    private void limpiarLabelsEstado() {
        limpiarLabelEstadoSeg();
        limpiarLabelEstadoTer();
        limpiarLabelEstadoCuart();
    }
    
    private void limpiarLabelEstadoSeg() {
        lblEstadoSeg.setText("");
        lblEstadoSeg.getStyleClass().clear();
    }
    
    private void limpiarLabelEstadoTer() {
        lblEstadoTer.setText("");
        lblEstadoTer.getStyleClass().clear();
    }
    
    private void limpiarLabelEstadoCuart() {
        lblEstadoCuart.setText("");
        lblEstadoCuart.getStyleClass().clear();
    }
    
    @FXML
    void regresarMainScreen(ActionEvent event) {
        NavegacionUtil.cambiarEscena(event, "/fxml/MainView.fxml");
    }
}