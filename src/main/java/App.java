import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/Formacion.fxml")
        );

        Scene scene = new Scene(loader.load());
        
        //Para evitar que el usuario haga muy pequeña la ventana
        //stage.setMinWidth(800);
        //stage.setMinHeight(600);
        //---------------------------------
        
        stage.setTitle("Datos personales");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
