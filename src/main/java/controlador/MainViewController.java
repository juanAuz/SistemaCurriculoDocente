package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import modelo.Docente;
import persistencia.DocentePersistencia;
import util.NavegacionUtil;
import util.SistemaDocente;

public class MainViewController implements Initializable {

    private Docente docente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        docente = SistemaDocente.getInstancia().getDocente();
    }

    @FXML
    void btnDatosPersonales(ActionEvent event) {
        NavegacionUtil.cambiarEscena(event, "/fxml/DatosPersonales.fxml");
    }

    @FXML
    void btnFormacionAcademica(ActionEvent event) {
        NavegacionUtil.cambiarEscena(event, "/fxml/Formacion.fxml");
    }

    @FXML
    void btnExperienciaLaboral(ActionEvent event) {
        NavegacionUtil.cambiarEscena(event, "/fxml/PlantillaExperiencia.fxml");
    }

    @FXML
    void btnCapacitaciones(ActionEvent event) {
        NavegacionUtil.cambiarEscena(event, "/fxml/CapacitacionPlantilla.fxml");
    }

    @FXML
    void btnProduccionAcademica(ActionEvent event) {
        NavegacionUtil.cambiarEscena(event, "/fxml/Producciones.fxml");
    }

    @FXML
    void btnSerializarTodo(ActionEvent event) {
        try {
            DocentePersistencia.guardar(docente);
            System.out.println("✓ Todos los datos guardados correctamente");
        } catch (Exception e) {
            System.err.println("✗ Error al guardar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    void btnCerrarPrograma(ActionEvent event) {
        System.exit(0);
    }
}