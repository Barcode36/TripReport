package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.Driver;
import model.State;
import model.Trip;
import model.Truck;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class TripJournalController extends MainController {
    @FXML
    private TextField tripNumberInput;
    @FXML
    private ComboBox driverNumberInput;
    @FXML
    private ComboBox coDriverNumberInput;
    @FXML
    private TextField dateDepartedInput;
    @FXML
    private TextField dateReturnedInput;
    @FXML
    private ComboBox truckNumberInput;
    @FXML
    private ComboBox stateCodeInput;
    @FXML
    private TextField mileageInput;
    @FXML
    private TextField commentInput;
    @FXML
    private TextField stationNameInput;
    @FXML
    private TextField stationLocationInput;
    @FXML
    private TextField priceInput;
    @FXML
    private TextField litresInput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        driverNumberInput.getItems().clear();
        coDriverNumberInput.getItems().clear();
        for(Driver driver: Driver.getAllDriver()) {
            driverNumberInput.getItems().addAll(driver.getDriverNo());
            coDriverNumberInput.getItems().addAll(driver.getDriverNo());
        }

        truckNumberInput.getItems().clear();
        for(Truck truck: Truck.getAllTruck())
            truckNumberInput.getItems().addAll(truck.getTruckNo());

        stateCodeInput.getItems().clear();
        for(State state: State.getAllState())
            stateCodeInput.getItems().addAll(state.getStateCode());

    }

    public void SubmitButton(ActionEvent actionEvent) {
        // Check if trip is valid
        if (checkFields()) {

            // Create trip
            Trip trip = new Trip();
            trip.setTripNo(tripNumberInput.getText());
            trip.setDriverNo(driverNumberInput.getSelectionModel().getSelectedItem().toString());
            trip.setCoDriverNo(coDriverNumberInput.getSelectionModel().getSelectedItem().toString());
//        trip.setDepartDate(Date.valueOf(dateDepartedInput.getText()));
//        trip.setReturnDate(Date.valueOf(dateReturnedInput.getText()));
            trip.setTruckNo(truckNumberInput.getSelectionModel().getSelectedItem().toString());
            trip.setStateCode(stateCodeInput.getSelectionModel().getSelectedItem().toString());
            trip.setMilesDriven(Integer.parseInt(mileageInput.getText()));
            trip.setComment(commentInput.getText());
            trip.setStationName(stationNameInput.getText());
            trip.setStationLocation(stationLocationInput.getText());
            trip.setFuelConsumption(Double.parseDouble(priceInput.getText()));
            trip.setGallonPurchased(Double.parseDouble(litresInput.getText()));

            // Save the trip
            // Check if successful and display alert
            Alert alert;
            if(Trip.saveTrip(trip)) {
                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("successfully added trip");
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Could not add trip");
            }
            alert.show();
        }
    }

    public boolean checkFields() {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        boolean invalid = false;

        if (!invalid && (invalid = tripNumberInput.getText().isEmpty()))
            alert.setContentText("tripNumber should not be empty");
        else if (!invalid && (invalid = mileageInput.getText().isEmpty()))
            alert.setContentText("Mileage should not be empty");
        else if (!invalid && (invalid = commentInput.getText().isEmpty()))
            alert.setContentText("Comment should not be empty");
        else if (!invalid && (invalid = stationNameInput.getText().isEmpty()))
            alert.setContentText("Station name should not be empty");
        else if (!invalid && (invalid = stationLocationInput.getText().isEmpty()))
            alert.setContentText("Station location should not be empty");
        else if (!invalid && (invalid = priceInput.getText().isEmpty()))
            alert.setContentText("Price should not be empty");
        else if (!invalid && (invalid = litresInput.getText().isEmpty()))
            alert.setContentText("Litres should not be empty");
        else if (!invalid && (invalid = litresInput.getText().matches(".*[a-z].*"))) {
            alert.setContentText("Litres should only contain numbers");
            litresInput.clear();
        }
        else if (!invalid && (invalid = priceInput.getText().matches(".*[a-z].*"))) {
            alert.setContentText("Prices should only contain numbers");
            priceInput.clear();
        }
        else if (!invalid && (invalid = mileageInput.getText().matches(".*[a-z].*"))) {
            alert.setContentText("Mileage should only contain numbers");
            mileageInput.clear();
        }else if (!invalid && (invalid = driverNumberInput.getSelectionModel().isEmpty()))
            alert.setContentText("Driver number should not be empty");
        else if (!invalid && (invalid = coDriverNumberInput.getSelectionModel().isEmpty()))
            alert.setContentText("Co Driver number should not be empty");
        else if (!invalid && (invalid = truckNumberInput.getSelectionModel().isEmpty()))
            alert.setContentText("Truck number should not be empty");
        else if (!invalid && (invalid = stateCodeInput.getSelectionModel().isEmpty()))
            alert.setContentText("State code should not be empty");



        if(invalid) {
            alert.show();
            return false;
        }
        else{
            return true;
        }
    }
}
