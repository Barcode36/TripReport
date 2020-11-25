package controler;

import javafx.event.ActionEvent;
import model.Driver;
import util.SceneController;

public class MainController {

     public void tripReportButton(ActionEvent actionEvent) {
         System.out.println("button pressed --> " +actionEvent.getSource().toString());
        new SceneController().setScene("../view/tripJournal.fxml", "Trip Report", 1000, 700);
    }

    public void reportButton(ActionEvent actionEvent) {
        System.out.println("button pressed --> " +actionEvent.getSource().toString());
//        new SceneController().setScene("", "", 1000, 700);
    }

    public void summaryButton(ActionEvent actionEvent) {
        System.out.println("button pressed --> " +actionEvent.getSource().toString());
//        new SceneController().setScene("", "", 1000, 700);
    }
}
