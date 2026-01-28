package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class NavegacionUtil {
    
    public static void cambiarEscena(ActionEvent event, String rutaFXML) {
        try {
            FXMLLoader loader = new FXMLLoader(
                NavegacionUtil.class.getResource(rutaFXML)
            );
            Parent root = loader.load();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error al cargar la vista: " + rutaFXML);
        }
    }
}