import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.Docente;
import persistencia.DocentePersistencia;
import util.SistemaDocente;

public class App extends Application {

    @Override
public void start(Stage stage) throws IOException {
    // Cargar UNA SOLA VEZ al inicio
    Docente docente = DocentePersistencia.cargar();
    SistemaDocente.getInstancia().setDocente(docente);
    System.out.println("✓ Datos cargados del archivo .dat");
    
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("/fxml/MainView.fxml")
    );
    Scene scene = new Scene(loader.load());
    stage.setScene(scene);
    
    // Guardar al cerrar la ventana
    stage.setOnCloseRequest(event -> {
        try {
            DocentePersistencia.guardar(docente);
            System.out.println("✓ Datos guardados automáticamente");
        } catch (Exception e) {
            System.err.println("✗ Error al guardar: " + e.getMessage());
            e.printStackTrace();
        }
    });
    
    stage.setTitle("Sistema de Gestión Docente - EPN");
    stage.show();
}

    public static void main(String[] args) {
        launch(args);
    }
}
