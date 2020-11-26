package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Trip;
import util.SceneController;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TripReportController extends MainController {
    @FXML
    private TextField searchInput;
    @FXML
    private Label tripNumberOutput;
    @FXML
    private Label driverNumberOutput;
    @FXML
    private Label coDriverNumberOutput;
    @FXML
    private Label daysOutput;
    @FXML
    private Label dateDepartedOutput;
    @FXML
    private Label dateReturnedOutput;
    @FXML
    private Label truckNumberOutput;
    @FXML
    private Label mileageOutput;
    @FXML
    private Label commentOutput;
    @FXML
    private Label fuelPriceOutput;
    @FXML
    private Label litersOutput;
    @FXML
    private Label totalOutput;

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
        if(trip.getReturnDate() != null && trip.getDepartDate() != null) {
            LocalDate returnDate = LocalDate.parse(trip.getReturnDate().toString(), DateTimeFormatter.BASIC_ISO_DATE);
            LocalDate departDate = LocalDate.parse(trip.getDepartDate().toString(), DateTimeFormatter.BASIC_ISO_DATE);
            Duration diff = Duration.between(returnDate, departDate);
            daysOutput.setText(diff.toString());
            dateDepartedOutput.setText(returnDate.toString());
            dateReturnedOutput.setText(departDate.toString());
        }
        Double pricePerLitre = trip.getFuelConsumption();
        Double litres = trip.getGallonPurchased();
        Double price = pricePerLitre * litres;

        tripNumberOutput.setText(trip.getTripNo());
        driverNumberOutput.setText(trip.getDriverNo());
        coDriverNumberOutput.setText(trip.getCoDriverNo());
        truckNumberOutput.setText(trip.getTruckNo());
        mileageOutput.setText(Double.toString(trip.getMilesDriven()));
        commentOutput.setText(trip.getComment());
        fuelPriceOutput.setText(Double.toString(pricePerLitre));
        litersOutput.setText(Double.toString(litres));
        totalOutput.setText(Double.toString(price));
    }

    public void exceptionsReportButton(ActionEvent actionEvent) {
        new SceneController().setScene("../view/exceptionsReport.fxml", "Exceptions Report", 1000, 800);
    }
}
