package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.Trip;

import java.lang.reflect.Array;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class SummaryReportController extends MainController {

    // KILOMETERS TRAVELED LABELS
    @FXML
    private Label total30DaysKM;
    @FXML
    private Label total180DaysKM;
    @FXML
    private Label total1YearKM;
    @FXML
    private Label average30DaysKM;
    @FXML
    private Label average180DaysKM;
    @FXML
    private Label average1YearKM;
    @FXML
    private Label median30DayKM;
    @FXML
    private Label median180DayKM;
    @FXML
    private Label median1YearKM;
    // -----------------------------------------------
    // FUEL USED LABELS
    @FXML
    private Label total30DaysFUEL;
    @FXML
    private Label total180DaysFUEL;
    @FXML
    private Label total1YearFUEL;
    @FXML
    private Label average30DaysFUEL;
    @FXML
    private Label average180DaysFUEL;
    @FXML
    private Label average1YearFUEL;
    @FXML
    private Label median30DayFUEL;
    @FXML
    private Label median180DayFUEL;
    @FXML
    private Label median1YearFUEL;
    // -----------------------------------------------
    // DAYS ON THE ROAD LABELS
    @FXML
    private Label total30DaysDAY;
    @FXML
    private Label total180DaysDAY;
    @FXML
    private Label total1YearDAY;
    @FXML
    private Label average30DaysDAY;
    @FXML
    private Label average180DaysDAY;
    @FXML
    private Label average1YearDAY;
    @FXML
    private Label median30DayDAY;
    @FXML
    private Label median180DayDAY;
    @FXML
    private Label median1YearDAY;

    private Trip trip = new Trip();

    // TOTALS
    private double total30Kilometer = 0;
    private double total180Kilometer = 0;
    private double totalYearKilometer = 0;
    private double total30Fuel = 0;
    private double total180Fuel = 0;
    private double totalYearFuel = 0;
    private double total30Days = 0;
    private double total180Days = 0;
    private double totalYearDays = 0;

    private double average30Kilometer = 0;
    private double average180Kilometer = 0;
    private double averageYearKilometer = 0;
    private double average30Fuel = 0;
    private double average180Fuel = 0;
    private double averageYearFuel = 0;
    private double average30Days = 0;
    private double average180Days = 0;
    private double averageYearDays = 0;

    // MEDIAN
    private double median30Kilometer = 0;
    private double median180Kilometer = 0;
    private double medianYearKilometer = 0;
    private double median30Fuel = 0;
    private double median180Fuel = 0;
    private double medianYearFuel = 0;
    private double median30Days = 0;
    private double median180Days = 0;
    private double medianYearDays = 0;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DecimalFormat d = new DecimalFormat("#0,000");

        List<Trip> list30 = Trip.getAllTrip(Trip.DAYS_30);
        List<Trip> list180 = Trip.getAllTrip(Trip.DAYS_180);
        List<Trip> listYear = Trip.getAllTrip(Trip.YEAR);

        List<Integer> list30KM = new ArrayList<>();
        List<Integer> list180KM = new ArrayList<>();
        List<Integer> listYearKM = new ArrayList<>();

        List<Double> list30FUEL = new ArrayList<>();
        List<Double> list180FUEL = new ArrayList<>();
        List<Double> listYearFUEL = new ArrayList<>();

        List<Integer> list30DAYS = new ArrayList<>();
        List<Integer> list180DAYS = new ArrayList<>();
        List<Integer> listYearDAYS = new ArrayList<>();

        for (Trip trip : list30)
            list30KM.add(trip.getMilesDriven());
        for (Trip trip : list180)
            list180KM.add(trip.getMilesDriven());
        for (Trip trip : listYear)
            listYearKM.add(trip.getMilesDriven());

        for (Trip trip : list30)
            list30FUEL.add(trip.getFuelConsumption() * trip.getGallonPurchased());
        for (Trip trip : list180)
            list180FUEL.add(trip.getFuelConsumption() * trip.getGallonPurchased());
        for (Trip trip : listYear)
            listYearFUEL.add(trip.getFuelConsumption() * trip.getGallonPurchased());

        for (Trip trip : list30)
            list30DAYS.add((int)ChronoUnit.DAYS.between(trip.getDepartDate().toLocalDate(), trip.getReturnDate().toLocalDate()));
        for (Trip trip : list180)
            list180DAYS.add((int)ChronoUnit.DAYS.between(trip.getDepartDate().toLocalDate(), trip.getReturnDate().toLocalDate()));
        for (Trip trip : listYear)
            listYearDAYS.add((int)ChronoUnit.DAYS.between(trip.getDepartDate().toLocalDate(), trip.getReturnDate().toLocalDate()));

        Collections.sort(list30KM);
        Collections.sort(list180KM);
        Collections.sort(listYearKM);

        Collections.sort(list30FUEL);
        Collections.sort(list180FUEL);
        Collections.sort(listYearFUEL);

        Collections.sort(list30DAYS);
        Collections.sort(list180DAYS);
        Collections.sort(listYearDAYS);

        if (list30.size() % 2 == 0) {
            median30Kilometer = ((double) list30KM.get(list30KM.size() / 2) + (double) list30KM.get(list30KM.size() / 2 - 1)) / 2;
            median30Fuel = ((double) list30FUEL.get(list30FUEL.size() / 2) + list30FUEL.get(list30FUEL.size() / 2 - 1)) / 2;
            median30Days = ((double) list30DAYS.get(list30DAYS.size() / 2) + list30DAYS.get(list30DAYS.size() / 2 - 1)) / 2;
        } else {
            median30Kilometer = (double) list30KM.get(list30KM.size() / 2);
            median30Fuel = list30FUEL.get(list30FUEL.size() / 2);
            median30Days = list30DAYS.get(list30DAYS.size() / 2);
        }
        if (list180.size() % 2 == 0) {
            median180Kilometer = ((double) list180KM.get(list180KM.size() / 2) + (double) list180KM.get(list180KM.size() / 2 - 1)) / 2;
            median180Fuel = ((double) list180FUEL.get(list180FUEL.size() / 2) + list180FUEL.get(list180FUEL.size() / 2 - 1)) / 2;
            median180Days = ((double) list180DAYS.get(list180DAYS.size() / 2) + list180DAYS.get(list180DAYS.size() / 2 - 1)) / 2;
        } else {
            median180Kilometer = (double) list180KM.get(list180KM.size() / 2);
            median180Fuel = list180FUEL.get(list180FUEL.size() / 2);
            median180Days = list180DAYS.get(list180DAYS.size() / 2);
        }
        if (listYear.size() % 2 == 0) {
            medianYearKilometer = ((double) listYearKM.get(listYearKM.size() / 2) + (double) listYearKM.get(listYearKM.size() / 2 - 1)) / 2;
            medianYearFuel = ((double) listYearFUEL.get(listYearFUEL.size() / 2) + listYearFUEL.get(listYearFUEL.size() / 2 - 1)) / 2;
            medianYearDays = ((double) listYearDAYS.get(listYearDAYS.size() / 2) + listYearDAYS.get(listYearDAYS.size() / 2 - 1)) / 2;
        } else {
            medianYearKilometer = (double) listYearKM.get(listYearKM.size() / 2);
            medianYearFuel = listYearFUEL.get(listYearFUEL.size() / 2);
            medianYearDays = listYearDAYS.get(listYearDAYS.size() / 2);
        }

        // --------------------   KILOMETER SECTION   ------------------//
        // SET THE NUMBERS
        total30Kilometer = list30.stream().mapToInt(o -> o.getMilesDriven()).sum();
        total180Kilometer = list180.stream().mapToInt(o -> o.getMilesDriven()).sum();
        totalYearKilometer = listYear.stream().mapToInt(o -> o.getMilesDriven()).sum();

        // AVERAGE
        average30Kilometer = list30.stream().mapToInt(o -> o.getMilesDriven()).average().orElse(0);
        average180Kilometer = list180.stream().mapToInt(o -> o.getMilesDriven()).average().orElse(0);
        averageYearKilometer = listYear.stream().mapToInt(o -> o.getMilesDriven()).average().orElse(0);

        // Medians are setup before this part.

        // SET THE LABELS
        total30DaysKM.setText(d.format(total30Kilometer) + " km");
        total180DaysKM.setText(d.format(total180Kilometer) + " km");
        total1YearKM.setText(d.format(totalYearKilometer) + " km");

        average30DaysKM.setText(d.format(average30Kilometer) + " km");
        average180DaysKM.setText(d.format(average180Kilometer) + " km");
        average1YearKM.setText(d.format(averageYearKilometer) + " km");

        median30DayKM.setText(d.format(median30Kilometer) + " km");
        median180DayKM.setText(d.format(median180Kilometer) + " km");
        median1YearKM.setText(d.format(medianYearKilometer) + " km");

        // --------------------   END OF KILOMETER SECTION   ------------------//


        // --------------------   FUEL SECTION   ------------------//

        // SET THE NUMBERS
        total30Fuel = list30.stream().mapToInt(o -> (int) (o.getFuelConsumption() * o.getGallonPurchased())).sum();
        total180Fuel = list180.stream().mapToInt(o -> (int) (o.getFuelConsumption() * o.getGallonPurchased())).sum();
        totalYearFuel = listYear.stream().mapToInt(o -> (int) (o.getFuelConsumption() * o.getGallonPurchased())).sum();

        average30Fuel = list30.stream().mapToInt(o -> (int) (o.getFuelConsumption() * o.getGallonPurchased())).average().orElse(0);
        average180Fuel = list180.stream().mapToInt(o -> (int) (o.getFuelConsumption() * o.getGallonPurchased())).average().orElse(0);
        averageYearFuel = listYear.stream().mapToInt(o -> (int) (o.getFuelConsumption() * o.getGallonPurchased())).average().orElse(0);

        // Medians are set before this part.

        // SET THE LABELS
        total30DaysFUEL.setText("$" + d.format(total30Fuel));
        total180DaysFUEL.setText("$" + d.format(total180Fuel));
        total1YearFUEL.setText("$" + d.format(totalYearFuel));

        average30DaysFUEL.setText("$" + d.format(average30Fuel));
        average180DaysFUEL.setText("$" + d.format(average180Fuel));
        average1YearFUEL.setText("$" + d.format(averageYearFuel));

        median30DayFUEL.setText("$" + d.format(median30Fuel));
        median180DayFUEL.setText("$" + d.format(median180Fuel));
        median1YearFUEL.setText("$" + d.format(medianYearFuel));

        // --------------------   END OF FUEL SECTION   ------------------//


        // --------------------   FUEL SECTION   ------------------//

        // SET THE NUMBERS
        total30Days = list30.stream().mapToInt(o -> (int) (ChronoUnit.DAYS.between(o.getDepartDate().toLocalDate(), o.getReturnDate().toLocalDate()))).sum();
        total180Days = list180.stream().mapToInt(o -> (int) (ChronoUnit.DAYS.between(o.getDepartDate().toLocalDate(), o.getReturnDate().toLocalDate()))).sum();
        totalYearDays = listYear.stream().mapToInt(o -> (int) (ChronoUnit.DAYS.between(o.getDepartDate().toLocalDate(), o.getReturnDate().toLocalDate()))).sum();

        average30Days = list30.stream().mapToDouble(o -> (double) (ChronoUnit.DAYS.between(o.getDepartDate().toLocalDate(), o.getReturnDate().toLocalDate()))).average().orElse(0);
        average180Days = list180.stream().mapToDouble(o -> (double) (ChronoUnit.DAYS.between(o.getDepartDate().toLocalDate(), o.getReturnDate().toLocalDate()))).average().orElse(0);
        averageYearDays = listYear.stream().mapToDouble(o -> (double) (ChronoUnit.DAYS.between(o.getDepartDate().toLocalDate(), o.getReturnDate().toLocalDate()))).average().orElse(0);

        for (Trip o : list30)
            System.out.println(ChronoUnit.DAYS.between(o.getDepartDate().toLocalDate(), o.getReturnDate().toLocalDate()));

        d = new DecimalFormat("#0.0");

        // SET THE LABELS
        total30DaysDAY.setText(d.format(total30Days) + " Days");
        total180DaysDAY.setText(d.format(total180Days) + "Days");
        total1YearDAY.setText(d.format(totalYearDays) + "Days");
        average30DaysDAY.setText(d.format(average30Days) + "Days");
        average180DaysDAY.setText(d.format(average180Days) + "Days");
        average1YearDAY.setText(d.format(averageYearDays) + "Days");
        median30DayDAY.setText(d.format(median30Days) + "Days");
        median180DayDAY.setText(d.format(median180Days) + "Days");
        median1YearDAY.setText(d.format(medianYearDays) + "Days");

        // --------------------   FUEL SECTION   ------------------//
    }
}
