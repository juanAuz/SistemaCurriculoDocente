
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
public void start(Stage primaryStage) {
    VBox root = new VBox(20);
    root.setAlignment(Pos.CENTER);
    
    Label titulo = new Label("✅ JavaFX Funciona Correctamente");
    titulo.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
    
    Label mensaje = new Label("Sistema de Gestión de Currículo Docente - EPN");
    mensaje.setStyle("-fx-font-size: 16px;");
    
    Label instrucciones = new Label("Si ves esto, Maven + JavaFX funcionan perfectamente 🚀");
    instrucciones.setStyle("-fx-font-size: 14px; -fx-text-fill: #27ae60;");
    
    root.getChildren().addAll(titulo, mensaje, instrucciones);
    
    Scene scene = new Scene(root, 600, 300);
    
    primaryStage.setTitle("Test - Sistema Currículo");
    primaryStage.setScene(scene);
    primaryStage.show();
}

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}