package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import util.SceneController;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void tripReportButton(ActionEvent actionEvent) {
        System.out.println("button pressed --> " + actionEvent.getSource().toString());
        new SceneController().setScene("../view/tripJournal.fxml", "Trip Report", 1000, 800);
    }

    public void reportButton(ActionEvent actionEvent) {
        System.out.println("button pressed --> " + actionEvent.getSource().toString());
        new SceneController().setScene("../view/tripReport.fxml", "", 1000, 800);
    }

    public void summaryButton(ActionEvent actionEvent) {
        System.out.println("button pressed --> " + actionEvent.getSource().toString());
        new SceneController().setScene("../view/summaryReport.fxml", "", 1000, 800);
    }
}
