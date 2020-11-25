import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Trip;

import java.io.IOException;

public class Controller {

    private final Stage stage;

    @FXML
    Button tripJournalButton;
    @FXML
    Button tripReportButton;
    @FXML
    Button summaryButton;

    public Controller() throws IOException {
        stage = new Stage();

        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getClassLoader().getResource("mainMenu.fxml"));
        stage.setTitle("Main Menu");
        stage.setScene(new Scene(root, 999,700));
        initialize();
    }

    public void showStage(){
        stage.showAndWait();
    }

    @FXML
    private void initialize(){
        tripJournalButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("yeet");
            }
        });
    }

    private void openTripJournalInputView(){
        TripJournalController tripJournalController = new TripJournalController(this);
        tripJournalController.showStage();
    }



}
