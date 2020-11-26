import javafx.application.Application;
import javafx.stage.Stage;
import util.DbConn;
import util.SceneController;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        // Set the stage
        SceneController.setStage(stage);
        stage.setResizable(false);

        // Set scene
        new SceneController().setScene("../view/mainMenu.fxml", "Main Menu", 989, 690);
    }

    public static void main(String[] args) {
        System.out.println("----- ----- ----- ----- ----- -----");
        System.out.println("----- ----- Trip Report ----- -----");
        System.out.println("");

        // Connect to database
        DbConn.connect();

        // Launch application
        launch(args);
    }
}
