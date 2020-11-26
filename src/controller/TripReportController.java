package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Trip;

public class TripReportController extends MainController {
    @FXML
    private TextField searchInput;

    public void searchTrip(ActionEvent actionEvent) {

        // Check if the input is empty
        if (searchInput.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Trip Number Cannot be empty");
            alert.show();
            return;
        }

        // Set the tripNo
        String tripNo = searchInput.getText();

        // Get the trip
        Trip trip = Trip.getTripByTripNo(tripNo);

        // Check if a trip was found
        if (trip == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Trip could not be found");
            alert.show();
            return;
        }


        //Todo display trip information

    }
}
