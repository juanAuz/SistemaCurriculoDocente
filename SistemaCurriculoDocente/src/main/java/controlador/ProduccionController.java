package controlador;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import modelo.produccion.Investigacion;
import modelo.produccion.Publicacion;
import util.SistemaDocente;
import javafx.scene.layout.HBox;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ProduccionController {
	
	@FXML private Label lblEstadoInv;
	@FXML private Label lblEstadoPub;
	
    // --- SECCIÓN INVESTIGACIONES ---
    @FXML private VBox panelAgregarInv;
    @FXML private VBox panelEditarInv;

    // TextFields Agregar
    @FXML private TextField txtTituloInvAgregar;
    @FXML private TextField txtInstitucionInvAgregar;
    @FXML private TextField txtAnioInvAgregar;

    // TextFields Editar
    @FXML private TextField txtTituloInvEditar;
    @FXML private TextField txtInstitucionInvEditar;
    @FXML private TextField txtAnioInvEditar;

    @FXML private TableView<Investigacion> tblInvestigaciones;
    @FXML private TableColumn<Investigacion, String> colTituloInv;
    @FXML private TableColumn<Investigacion, String> colInstitucionInv;
    @FXML private TableColumn<Investigacion, String> colAnioInv;
    @FXML private TableColumn<Investigacion, Void> colAccionInv; // Columna para botones

    // Variable para saber qué se está editando actualmente
    private Investigacion investigacionEnEdicion;
    
 // --- SECCIÓN PUBLICACIONES ---
    @FXML private VBox panelAgregarPub, panelEditarPub;

    // TextFields Agregar/Editar
    @FXML private TextField txtTituloPubAgregar, txtEditorialPubAgregar, txtAnioPubAgregar;
    @FXML private TextField txtTituloPubEditar, txtEditorialPubEditar, txtAnioPubEditar;

    @FXML private TableView<Publicacion> tblPublicaciones;
    @FXML private TableColumn<Publicacion, String> colTituloPub, colEditorialPub, colAnioPub;
    @FXML private TableColumn<Publicacion, Void> colAccionPub;

    private Publicacion publicacionEnEdicion;
    @FXML
    public void initialize() {
        // 1. Configurar estado inicial: Mostrar Agregar, Ocultar Editar
        mostrarModoAgregarInv(true);

        // 2. Configurar las columnas de la tabla (Qué dato va en qué columna)
        colTituloInv.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        colInstitucionInv.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getInstitucion()));
        colAnioInv.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAnio())));
        
     // 3. Configurar la columna de BOTONES (Acción)
        configurarBotonesTablaInv();


        // 4. Conectar la tabla a la lista del Singleton
        tblInvestigaciones.setItems(SistemaDocente.getInstancia().getDocente().getInvestigaciones());
        
     // 1. Estado inicial Publicaciones
        mostrarModoAgregarPub(true);

        // 2. Columnas Publicaciones
        colTituloPub.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        colEditorialPub.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEditorial()));
        colAnioPub.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAnio())));

        // 3. Botones y Datos
        configurarBotonesTablaPub();
        tblPublicaciones.setItems(SistemaDocente.getInstancia().getDocente().getPublicaciones());
    }


    // --- MÉTODOS DE APOYO PARA VISIBILIDAD ---

    private void mostrarModoAgregarInv(boolean mostrar) {
        // Si mostrar es true: panelAgregar visible, panelEditar oculto
        panelAgregarInv.setVisible(mostrar);
        panelAgregarInv.setManaged(mostrar); // "Managed" hace que no ocupe espacio si está oculto

        panelEditarInv.setVisible(!mostrar);
        panelEditarInv.setManaged(!mostrar);
    }
    
    private void mostrarModoAgregarPub(boolean mostrar) {
        // Si mostrar es true: panelAgregar visible, panelEditar oculto
        panelAgregarPub.setVisible(mostrar);
        panelAgregarPub.setManaged(mostrar); // "Managed" hace que no ocupe espacio si está oculto

        panelEditarPub.setVisible(!mostrar);
        panelEditarPub.setManaged(!mostrar);
    }

    private void cargarDatosParaEditarInv(Investigacion inv) {
        this.investigacionEnEdicion = inv;
        txtTituloInvEditar.setText(inv.getTitulo());
        txtInstitucionInvEditar.setText(inv.getInstitucion());
        txtAnioInvEditar.setText(String.valueOf(inv.getAnio()));
        mostrarModoAgregarInv(false); // Cambiar a modo edición
    }

    private void cargarDatosParaEditarPub(Publicacion pub) {
        this.publicacionEnEdicion = pub;
        txtTituloPubEditar.setText(pub.getTitulo());
        txtEditorialPubEditar.setText(pub.getEditorial());
        txtAnioPubEditar.setText(String.valueOf(pub.getAnio()));
        mostrarModoAgregarPub(false); // Cambiar a modo edición
    }
    
    // --- MÉTODOS DE LOS BOTONES ---

    @FXML
    void btnAgregarInvOnAction() {
        try {
            // 1. Obtener datos (Validación básica)
            String titulo = txtTituloInvAgregar.getText().trim();
            String institucion = txtInstitucionInvAgregar.getText().trim();
            String anioStr = txtAnioInvAgregar.getText().trim();

            if (titulo.isEmpty() || institucion.isEmpty() || anioStr.isEmpty()) {
                // Aquí podrías mostrar una alerta (Alert) al usuario
            	mostrarMensajeInv("Por favor, llena todos los campos.", true);
                return;
            }

            // 2. Crear el objeto
            int anio = Integer.parseInt(anioStr);
            Investigacion nueva = new Investigacion(titulo, institucion, anio);

            // 3. Añadir al Singleton
            SistemaDocente.getInstancia().getDocente().getInvestigaciones().add(nueva);

            // 4. Limpiar campos
            btnLimpiarInvOnAction();
            mostrarMensajeInv("Registro añadido correctamente.", false);
            
        } catch (NumberFormatException e) {
        	mostrarMensajeInv("El año debe ser un número válido.", true);
        }
    }
    
    @FXML
    void btnAgregarPubOnAction() {
        try {
            // 1. Obtener datos (Validación básica)
            String titulo = txtTituloPubAgregar.getText().trim();
            String editorial = txtEditorialPubAgregar.getText().trim();
            String anioStr = txtAnioPubAgregar.getText().trim();

            if (titulo.isEmpty() || editorial.isEmpty() || anioStr.isEmpty()) {
                // Aquí podrías mostrar una alerta (Alert) al usuario
                mostrarMensajePub("Por favor, llena todos los campos.", true);
                return;
            }

            // 2. Crear el objeto
            int anio = Integer.parseInt(anioStr);
            Publicacion nueva = new Publicacion(titulo, editorial, anio);

            // 3. Añadir al Singleton
            SistemaDocente.getInstancia().getDocente().getPublicaciones().add(nueva);

            // 4. Limpiar campos
            btnLimpiarPubOnAction();
            mostrarMensajePub("Registro añadido correctamente.", false);
            
        } catch (NumberFormatException e) {
            mostrarMensajePub("El año debe ser un número válido.", true);
        }
    }
    
    //Boton para actualizar los datos de una investigacion
    @FXML
    void btnActualizarInvOnAction() {
        if (investigacionEnEdicion != null) {
            try {
                // 1. Actualizar las propiedades del objeto existente
                investigacionEnEdicion.setTitulo(txtTituloInvEditar.getText());
                investigacionEnEdicion.setInstitucion(txtInstitucionInvEditar.getText());
                investigacionEnEdicion.setAnio(Integer.parseInt(txtAnioInvEditar.getText()));

                // 2. Refrescar la tabla para mostrar los cambios
                tblInvestigaciones.refresh();

                // 3. Regresar al panel de "Agregar"
                mostrarModoAgregarInv(true); 
                
                // 4. Limpiar la referencia y los campos
                investigacionEnEdicion = null;
                limpiarCamposInvEditar();
                mostrarMensajeInv("Registro actualizado correctamente.", false);
                
            } catch (NumberFormatException e) {
                mostrarMensajeInv("Error en el formato del año.", true);
            }
        }
    }
    
  //Boton para actualizar los datos de una publicacion
    @FXML
    void btnActualizarPubOnAction() {
        if (publicacionEnEdicion != null) {
            try {
                // 1. Actualizar las propiedades del objeto existente
            	publicacionEnEdicion.setTitulo(txtTituloPubEditar.getText());
            	publicacionEnEdicion.setEditorial(txtEditorialPubEditar.getText());
            	publicacionEnEdicion.setAnio(Integer.parseInt(txtAnioPubEditar.getText()));

                // 2. Refrescar la tabla para mostrar los cambios
                tblPublicaciones.refresh();

                // 3. Regresar al panel de "Agregar"
                mostrarModoAgregarPub(true); 
                
                // 4. Limpiar la referencia y los campos
                publicacionEnEdicion = null;
                limpiarCamposPubEditar();
                mostrarMensajePub("Registro actualizado correctamente.", false);
                
            } catch (NumberFormatException e) {
                mostrarMensajePub("Error en el formato del año.", true);
            }
        }
    }
    
    @FXML
    void btnLimpiarInvOnAction() {
        txtTituloInvAgregar.clear();
        txtInstitucionInvAgregar.clear();
        txtAnioInvAgregar.clear();
        mostrarMensajeInv("", true);
    }
    
    @FXML
    void btnLimpiarPubOnAction() {
        txtTituloPubAgregar.clear();
        txtEditorialPubAgregar.clear();
        txtAnioPubAgregar.clear();
        mostrarMensajePub("", true);
    }
    
    // Método auxiliar para el panel de edición
    private void limpiarCamposInvEditar() {
        txtTituloInvEditar.clear();
        txtInstitucionInvEditar.clear();
        txtAnioInvEditar.clear();
    }
    
    private void limpiarCamposPubEditar() {
        txtTituloPubEditar.clear();
        txtEditorialPubEditar.clear();
        txtAnioPubEditar.clear();
    }
    
    
    @FXML
    void btnCancelarInvOnAction() {
        mostrarModoAgregarInv(true);
        investigacionEnEdicion = null;
        mostrarMensajeInv("", true);
    }
    
    @FXML
    void btnCancelarPubOnAction() {
        mostrarModoAgregarPub(true);
        publicacionEnEdicion = null;
        mostrarMensajePub("", true);
    }
    
    private void configurarBotonesTablaInv() {
        colAccionInv.setCellFactory(param -> new TableCell<>() {
            private final Button btnEditar = new Button("Editar");
            private final Button btnBorrar = new Button("Borrar");
            private final HBox pane = new HBox(btnEditar, btnBorrar);

            {
                pane.setSpacing(10);
                btnEditar.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
                btnBorrar.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");

                btnEditar.setOnAction(event -> {
                    Investigacion inv = getTableView().getItems().get(getIndex());
                    cargarDatosParaEditarInv(inv); // Método que cambia paneles
                    mostrarMensajeInv("", true);
                });

                btnBorrar.setOnAction(event -> {
                    Investigacion inv = getTableView().getItems().get(getIndex());
                    SistemaDocente.getInstancia().getDocente().getInvestigaciones().remove(inv);
                    if (investigacionEnEdicion != null && investigacionEnEdicion.equals(inv)) {
                        btnCancelarInvOnAction(); // Esto oculta el panel de edición y limpia la variable
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : pane);
            }
        });
    }
    
    private void configurarBotonesTablaPub() {
        colAccionPub.setCellFactory(param -> new TableCell<>() {
            private final Button btnEditar = new Button("Editar");
            private final Button btnBorrar = new Button("Borrar");
            private final HBox pane = new HBox(btnEditar, btnBorrar);

            {
                pane.setSpacing(10);
                btnEditar.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
                btnBorrar.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");

                btnEditar.setOnAction(event -> {
                    Publicacion pub = getTableView().getItems().get(getIndex());
                    cargarDatosParaEditarPub(pub); // Método que cambia paneles
                    mostrarMensajePub("", true);
                    
                });

                btnBorrar.setOnAction(event -> {
                	Publicacion pub = getTableView().getItems().get(getIndex());
                    SistemaDocente.getInstancia().getDocente().getPublicaciones().remove(pub);
                    if (publicacionEnEdicion != null && publicacionEnEdicion.equals(pub)) {
                        btnCancelarPubOnAction(); // Esto oculta el panel de edición y limpia la variable
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                setGraphic(empty ? null : pane);
            }
        });
    }
    
    private void mostrarMensajeInv(String mensaje, boolean esError) {
        lblEstadoInv.setText(mensaje);
        if (esError) {
            lblEstadoInv.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        } else {
            lblEstadoInv.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        }
    }
    
    private void mostrarMensajePub(String mensaje, boolean esError) {
        lblEstadoPub.setText(mensaje);
        if (esError) {
        	lblEstadoPub.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        } else {
        	lblEstadoPub.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
        }
    }
}