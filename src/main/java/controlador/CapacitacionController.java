package controlador;

import modelo.capacitacion.Capacitacion;
import modelo.capacitacion.CapacitacionImpartida;
import modelo.capacitacion.CapacitacionRecibida;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.time.LocalDate;
import util.*;

public class CapacitacionController {

    // --- 1. Componentes de la Interfaz (Deben coincidir con fx:id en SceneBuilder) ---
    @FXML private ComboBox<String> cmbTipo;
    @FXML private TextField txtTema;
    @FXML private TextField txtInstitucion;
    @FXML private DatePicker dpInicio;
    @FXML private DatePicker dpFin;
    @FXML private TextField txtHoras;

    // Campos Específicos (Se ocultan/muestran)
    @FXML private TextField txtEstado;   // Solo para Recibida
    @FXML private TextField txtPublico;  // Solo para Impartida
    
    // Labels Específicos (Opcional: dales fx:id en SceneBuilder para ocultarlos también)
    @FXML private Label lblEstado;       
    @FXML private Label lblPublico;      

    // Tabla y Columnas
    @FXML private TableView<Capacitacion> tblCapacitaciones;
    @FXML private TableColumn<Capacitacion, String> colTema;
    @FXML private TableColumn<Capacitacion, String> colInstitucion;
    @FXML private TableColumn<Capacitacion, String> colTipo;
    @FXML private TableColumn<Capacitacion, String> colDetalle; // Muestra Estado o Público

    // --- 2. Modelo de Datos (Colección Observable) ---
    // Aquí aplicamos Polimorfismo: La lista es de 'Capacitacion' pero guarda hijas
    private ObservableList<Capacitacion> listaCapacitaciones = FXCollections.observableArrayList();

    // --- 3. Inicialización (Se ejecuta al abrir la ventana) ---
    @FXML
    public void initialize() {
        // Configurar el ComboBox
        cmbTipo.getItems().addAll("Recibida", "Impartida");
        
        // Listener: Detectar cambios en el combo para ocultar campos
        cmbTipo.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            actualizarVisibilidad(newVal);
        });
        cmbTipo.getSelectionModel().select("Recibida"); // Valor por defecto

        // Configurar las columnas de la tabla
        colTema.setCellValueFactory(new PropertyValueFactory<>("tema"));
        colInstitucion.setCellValueFactory(new PropertyValueFactory<>("institucion"));
        // Estas propiedades usan los métodos abstractos (Polimorfismo puro)
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo")); 
        colDetalle.setCellValueFactory(new PropertyValueFactory<>("detalle"));

        // Enlazar la lista a la tabla visual
        tblCapacitaciones.setItems(listaCapacitaciones);
    }

    // Método auxiliar para ocultar/mostrar filas
    private void actualizarVisibilidad(String tipo) {
        boolean esRecibida = "Recibida".equals(tipo);
        
        // Mostrar campos de Recibida, ocultar los de Impartida (o viceversa)
        txtEstado.setVisible(esRecibida);
        txtEstado.setManaged(esRecibida); // setManaged hace que el espacio se colapse si está oculto
        if(lblEstado != null) { lblEstado.setVisible(esRecibida); lblEstado.setManaged(esRecibida); }

        txtPublico.setVisible(!esRecibida);
        txtPublico.setManaged(!esRecibida);
        if(lblPublico != null) { lblPublico.setVisible(!esRecibida); lblPublico.setManaged(!esRecibida); }
    }

    // --- 4. Lógica del Botón "Agregar" ---
    @FXML
    private void agregarCapacitacion(ActionEvent event) {
        try {
            // A. Recolectar datos comunes
            String tema = txtTema.getText();
            String institucion = txtInstitucion.getText();
            LocalDate inicio = dpInicio.getValue();
            LocalDate fin = dpFin.getValue();
            
            // Validación básica [cite: 78]
            if (tema.isEmpty() || institucion.isEmpty() || inicio == null || fin == null || txtHoras.getText().isEmpty()) {
                mostrarAlerta("Error", "Por favor llene todos los campos obligatorios.");
                return;
            }

            int horas = Integer.parseInt(txtHoras.getText()); // Puede lanzar excepción si no es número
            String seleccion = cmbTipo.getValue();

            // B. Crear el objeto usando Polimorfismo 
            Capacitacion nuevaCapacitacion = null;

            if ("Recibida".equals(seleccion)) {
                String estado = txtEstado.getText();
                if (estado.isEmpty()) { mostrarAlerta("Error", "Ingrese el estado/certificado."); return; }
                
                nuevaCapacitacion = new CapacitacionRecibida(tema, institucion, inicio, fin, horas, estado);
            
            } else {
                String publico = txtPublico.getText();
                if (publico.isEmpty()) { mostrarAlerta("Error", "Ingrese el público dirigido."); return; }
                
                nuevaCapacitacion = new CapacitacionImpartida(tema, institucion, inicio, fin, horas, publico);
            }

            // C. Agregar a la lista (La tabla se actualiza sola)
            listaCapacitaciones.add(nuevaCapacitacion);
            
            // D. Limpiar formulario
            limpiarCampos();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error de Formato", "El campo 'Horas' debe ser un número entero.");
        } catch (Exception e) {
            mostrarAlerta("Error", "Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    @FXML
    private void limpiarCampos() {
        txtTema.clear();
        txtInstitucion.clear();
        txtHoras.clear();
        txtEstado.clear();
        txtPublico.clear();
        dpInicio.setValue(null);
        dpFin.setValue(null);
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @FXML
    void regresarMainScreen(ActionEvent event) {
        NavegacionUtil.cambiarEscena(event, "/fxml/MainScreen.fxml");
    }
}
