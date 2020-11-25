import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenu extends Application {

    @Override
    public void start(Stage stage1) throws Exception{
        Controller controller = new Controller();
        controller.showStage();
    }
    Parent root;

    public static void main(String[] args) {
        launch(args);
    }


}
