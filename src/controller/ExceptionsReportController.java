package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Trip;

import javax.swing.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ExceptionsReportController extends MainController {
    @FXML
    private ChoiceBox valueInputSearch;
    @FXML
    private ChoiceBox exceptionInputSearch;
    @FXML
    private TextField numberInputSearch;
    @FXML
    private Label resultsFound;
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
    private List<Trip> tripList = new ArrayList<>();
    private int index;
    private boolean isSearched = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> fields = new ArrayList<String>(Arrays.asList("", "Trip Number", "Driver Number", "Co-Driver Number", "Days", "Date Departed", "Date Returned",
                "Truck Number", "Mileage", "Comment", "Fuel Price", "Liters Purchased", "Total"));
        List<String> operators = new ArrayList<String>(Arrays.asList("<", "<=", "=", ">=", ">", "All"));
        valueInputSearch.getItems().addAll(fields);
        exceptionInputSearch.getItems().addAll(operators);

        resultsFound.setText("Waiting for query");
    }

    public void searchButton(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        String field = "";
        String operator = "";
        String condition = "";
        String method = "";
        boolean valid = true;
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

        switch (exceptionInputSearch.getSelectionModel().getSelectedItem().toString()) {
            case "All":
                method = "getAll";
                break;
            default:
                operator = exceptionInputSearch.getSelectionModel().getSelectedItem().toString();
                break;
        }

        if (method.equals("getAll")) {
            isSearched = true;
            valueInputSearch.getSelectionModel().selectFirst();

            tripList = Trip.getAllTrip();
            resultsFound.setText(Integer.toString(tripList.size()) + " results");

            putData(tripList.get(0));
            index = 0;
        } else {
            isSearched = true;
            if (!valueInputSearch.getSelectionModel().getSelectedItem().toString().isEmpty()) {
                String value = numberInputSearch.getText();
                switch (valueInputSearch.getSelectionModel().getSelectedItem().toString()) {
                    case "Trip Number":
                        field = "tripNo";
                        if(!value.matches("^[0-9]*$")) {
                            valid = false;
                            alert.setContentText("Trip number should not contain characters");
                            alert.show();
                        }
                        else{
                            valid = true;
                        }
                        break;
                    case "Driver Number":
                        field = "driverNo";
                        if(!value.matches("^[0-9]*$")) {
                            valid = false;
                            alert.setContentText("Driver number should not contain characters");
                            alert.show();
                        }
                        else{
                            valid = true;
                        }
                        break;
                    case "Co-Driver Number":
                        field = "coDriverNo";
                        if(!value.matches("^[0-9]*$")) {
                            valid = false;
                            alert.setContentText("Trip number should not contain characters");
                            alert.show();
                        }
                        else{
                            valid = true;
                        }
                        break;
                    case "Days":
                        field = "returnDate - departDate";
                        if(!value.matches("^[0-9]*$")) {
                            valid = false;
                            alert.setContentText("Days should not contain characters");
                            alert.show();
                        }
                        else{
                            valid = true;
                        }
                        break;
                    case "Date Departed":
                        field = "departDate";
                        df.setLenient(false);
                        try {
                            df.parse(value);
                            valid = true;
                        }
                        catch (ParseException e){
                            valid = false;
                            alert.setContentText("Date format should be yyyy-mm-dd");
                            alert.show();
                        }
                        break;
                    case "Date Returned":
                        field = "returnDate";
                        df.setLenient(false);
                        try {
                            df.parse(value);
                            valid = true;
                        }
                        catch (ParseException e){
                            valid = false;
                            alert.setContentText("Date format should be yyyy-mm-dd");
                            alert.show();
                        }
                        break;
                    case "Truck Number":
                        field = "truckNo";
                        if(!value.matches("^[0-9]*$")) {
                            valid = false;
                            alert.setContentText("Truck number should not contain characters");
                            alert.show();
                        }
                        else{
                            valid = true;
                        }
                        break;
                    case "Mileage":
                        field = "milesDriven";
                        if(!value.matches("^[0-9]*$")) {
                            valid = false;
                            alert.setContentText("Mileage should not contain characters");
                            alert.show();
                        }
                        else{
                            valid = true;
                        }
                        break;
                    case "Comment":
                        field = "comment";
                        break;
                    case "Fuel Price":
                        field = "fuelConsumption";
                        if(!value.matches("^[0-9]*$")) {
                            valid = false;
                            alert.setContentText("Fuel price should not contain characters");
                            alert.show();
                        }
                        else{
                            valid = true;
                        }
                        break;
                    case "Liters Purchased":
                        field = "gallonPurchased";
                        if(!value.matches("^[0-9]*$")) {
                            valid = false;
                            alert.setContentText("Liters Purchased should not contain characters");
                            alert.show();
                        }
                        else{
                            valid = true;
                        }
                        break;
                    case "Total":
                        field = "fuelConsumption * gallonPurchased";
                        if(!value.matches("^[0-9]*$")) {
                            valid = false;
                            alert.setContentText("Total should not contain characters");
                            alert.show();
                        }
                        else{
                            valid = true;
                        }
                        break;
                    default:
                        alert.setContentText("Fields should not be empty");
                        alert.show();
                        break;
                }
                ;
            }
            if(valid) {
                condition = numberInputSearch.getText();
                System.out.println(field);
                System.out.println(operator);
                System.out.println(condition);
                operator = exceptionInputSearch.getSelectionModel().getSelectedItem().toString();

                tripList = Trip.getTripBy(field, operator, condition);

                putData(tripList.get(0));
                resultsFound.setText(Integer.toString(tripList.size()) + " results");
            }
        }
    }

    public void nextButton(ActionEvent event) {
        if (isSearched) {
            if (index + 1 < tripList.size()) {
                index++;
                resultsFound.setText(index + 1 + "/" + tripList.size());
                clearLabels();
                putData(tripList.get(index));
            }
        }
    }

    public void previousButton(ActionEvent event) {
        if (isSearched) {
            if (index - 1 >= 0) {
                index--;
                resultsFound.setText(index + "/" + tripList.size());
                clearLabels();
                putData(tripList.get(index));
            }
        }
    }

    public void clearLabels() {
        tripNumberOutput.setText("");
        driverNumberOutput.setText("");
        coDriverNumberOutput.setText("");
        truckNumberOutput.setText("");
        mileageOutput.setText("");
        commentOutput.setText("");
        fuelPriceOutput.setText("");
        litersOutput.setText("");
        totalOutput.setText("");
        daysOutput.setText("");
        dateDepartedOutput.setText("");
        dateReturnedOutput.setText("");
    }

    public void putData(Trip trip) {
        if (trip.getReturnDate() != null && trip.getDepartDate() != null) {
            LocalDate returnDate = trip.getReturnDate().toLocalDate();
            LocalDate departDate = trip.getDepartDate().toLocalDate();

            daysOutput.setText(Long.toString(ChronoUnit.DAYS.between(departDate, returnDate)));
            dateDepartedOutput.setText(departDate.toString());
            dateReturnedOutput.setText(returnDate.toString());
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

}
