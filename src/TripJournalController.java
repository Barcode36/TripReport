import javafx.stage.Stage;

public class TripJournalController {
    private Stage stage;

    private Controller controller;

    public TripJournalController(Controller controller){
        this.controller = controller;


    }
    public void showStage(){
        stage.showAndWait();
    }

}
