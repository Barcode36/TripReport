package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import model.Trip;

import java.sql.Date;

public class TripJournalController extends MainController {
    @FXML
    private TextField tripNumberInput;
    @FXML
    private TextField driverNumberInput;
    @FXML
    private TextField coDriverNumberInput;
    @FXML
    private TextField dateDepartedInput;
    @FXML
    private TextField dateReturnedInput;
    @FXML
    private TextField truckNumberInput;
    @FXML
    private TextField stateCodeInput;
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
    private String contentText;

    public void SubmitButton(ActionEvent actionEvent) {
        Trip trip = new Trip();
        if (checkFields()) {
            trip.setTripNo(tripNumberInput.getText());
            trip.setDriverNo(driverNumberInput.getText());
            trip.setCoDriverNo(coDriverNumberInput.getText());
//        trip.setDepartDate(Date.valueOf(dateDepartedInput.getText()));
//        trip.setReturnDate(Date.valueOf(dateReturnedInput.getText()));
            trip.setTruckNo(truckNumberInput.getText());
            trip.setStateCode(stateCodeInput.getText());
            trip.setMilesDriven(Integer.parseInt(mileageInput.getText()));
            trip.setComment(commentInput.getText());
            trip.setStationName(stationNameInput.getText());
            trip.setStationLocation(stationLocationInput.getText());
            trip.setFuelConsumption(Double.parseDouble(priceInput.getText()));
            trip.setGallonPurchased(Double.parseDouble(litresInput.getText()));

            Trip.saveTrip(trip);
//        new SceneController().setScene("", "", 1000, 700);
        }
    }

    public boolean checkFields() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        boolean yeet = false;
        System.out.println(mileageInput.getText().isEmpty());

        if (tripNumberInput.getText().isEmpty())
            alert.setContentText(contentText);
        else if (mileageInput.getText().isEmpty())
            alert.setContentText("Mileage should not be empty");
        else if (commentInput.getText().isEmpty())
            alert.setContentText("Comment should not be empty");
        else if (stationNameInput.getText().isEmpty())
            alert.setContentText("Station name should not be empty");
        else if (stationLocationInput.getText().isEmpty())
            alert.setContentText("Station location should not be empty");
        else if (priceInput.getText().isEmpty())
            alert.setContentText("Price should not be empty");
        else if (litresInput.getText().isEmpty())
            alert.setContentText("Litres should not be empty");
        else if (litresInput.getText().matches(".*[a-z].*")) {
            alert.setContentText("Litres should only contain numbers");
            litresInput.clear();
        }
        else if (priceInput.getText().matches(".*[a-z].*")) {
            alert.setContentText("Prices should only contain numbers");
            priceInput.clear();
        }
        else if (mileageInput.getText().matches(".*[a-z].*")) {
            alert.setContentText("Mileage should only contain numbers");
            mileageInput.clear();
        }
        if(alert.getContentText() == null) {
            return true;
        }
        else{
            alert.show();
            return false;
        }


    }


}
