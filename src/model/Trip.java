package model;

import util.DbConn;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Trip {
    private int id;
    private String tripNo;
    private String driverNo;
    private String coDriverNo;
    private String truckNo;
    private String stateCode;
    private Date departDate;
    private Date returnDate;
    private int milesDriven;
    private String fuelReceiptNumber;
    private double fuelPaid;
    private double taxesPaid;
    private String stationName;
    private String stationLocation;
    private double gallonPurchased;
    private double fuelConsumption;
    private String comment;

    public Trip() {
    }


    public static Trip getTrip(int id) {
        try {
            // Create trip
            Trip trip = new Trip();

            // Execute sql
            ResultSet rs = DbConn.getConn().prepareStatement("select * from Trip where id = " + id).executeQuery();

            // Fill out trip
            rs.next();
            trip = rsToTrip(rs);

            return trip;
        } catch (SQLException e) {
            return null;
        }
    }

    public static List<Trip> getAllTrip() {
        try {
            // Create list
            List<Trip> trips = new ArrayList<Trip>();

            // Execute sql
            ResultSet rs = DbConn.getConn().prepareStatement("select * from Trip").executeQuery();

            // Fill out list
            while (rs.next()) {
                trips.add(rsToTrip(rs));
            }

            return trips;
        } catch (SQLException e) {
            return null;
        }
    }

    public static int saveTrip(Trip trip) {
        try {

            PreparedStatement statement = DbConn.getConn().prepareStatement("" +
                    "insert into Trip " +
                    "(tripNo, driverNo, coDriverNo, truckNo, stateCode, departDate, returnDate, milesDriven, fuelReceiptNumber, fuelPaid, taxesPaid, stationName, stationLocation, gallonPurchased, fuelConsumption, comment)" +
                    "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            statement.setString(1, trip.tripNo == null ? "" : trip.tripNo);
            statement.setString(2, trip.driverNo == null ? "" : trip.driverNo);
            statement.setString(3, trip.coDriverNo == null ? "" : trip.coDriverNo);
            statement.setString(4, trip.truckNo == null ? "" : trip.truckNo);
            statement.setString(5, trip.stateCode == null ? "" : trip.stateCode);
            statement.setDate(6, trip.departDate);
            statement.setDate(7, trip.returnDate);
            statement.setInt(8, trip.milesDriven);
            statement.setString(9, trip.fuelReceiptNumber == null ? "" : trip.fuelReceiptNumber);
            statement.setDouble(10, trip.fuelPaid);
            statement.setDouble(11, trip.taxesPaid);
            statement.setString(12, trip.stationLocation == null ? "" : trip.stationLocation);
            statement.setString(13, trip.stationLocation == null ? "" : trip.stationLocation);
            statement.setDouble(14, trip.gallonPurchased);
            statement.setDouble(15, trip.fuelConsumption);
            statement.setString(16, trip.comment == null ? "" : trip.comment);

            return statement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    private static Trip rsToTrip(ResultSet rs) throws SQLException {
        Trip trip = new Trip();

        trip.id = rs.getInt("id");
        trip.tripNo = rs.getString("tripNo");
        trip.driverNo = rs.getString("driverNo");
        trip.coDriverNo = rs.getString("coDriverNo");
        trip.truckNo = rs.getString("truckNo");
        trip.stateCode = rs.getString("stateCode");
        trip.departDate = rs.getDate("departDate");
        trip.returnDate = rs.getDate("returnDate");
        trip.milesDriven = rs.getInt("milesDriven");
        trip.fuelReceiptNumber = rs.getString("fuelReceiptNumber");
        trip.fuelPaid = rs.getDouble("fuelPaid");
        trip.taxesPaid = rs.getDouble("taxesPaid");
        trip.stationName = rs.getString("stationName");
        trip.stationLocation = rs.getString("stationLocation");
        trip.gallonPurchased = rs.getDouble("gallonPurchased");
        trip.fuelConsumption = rs.getDouble("fuelConsumption");
        trip.comment = rs.getString("comment");

        return trip;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", tripNo='" + tripNo + '\'' +
                ", driverNo='" + driverNo + '\'' +
                ", coDriverNo='" + coDriverNo + '\'' +
                ", truckNo='" + truckNo + '\'' +
                ", stateCode='" + stateCode + '\'' +
                ", departDate=" + departDate +
                ", returnDate=" + returnDate +
                ", milesDriven=" + milesDriven +
                ", fuelReceiptNumber='" + fuelReceiptNumber + '\'' +
                ", fuelPaid=" + fuelPaid +
                ", taxesPaid=" + taxesPaid +
                ", stationName='" + stationName + '\'' +
                ", stationLocation='" + stationLocation + '\'' +
                ", gallonPurchased='" + gallonPurchased + '\'' +
                ", fuelConsumption='" + fuelConsumption + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getTripNo() {
        return tripNo;
    }

    public String getDriverNo() {
        return driverNo;
    }

    public String getCoDriverNo() {
        return coDriverNo;
    }

    public String getTruckNo() {
        return truckNo;
    }

    public String getStateCode() {
        return stateCode;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public int getMilesDriven() {
        return milesDriven;
    }

    public String getFuelReceiptNumber() {
        return fuelReceiptNumber;
    }

    public double getFuelPaid() {
        return fuelPaid;
    }

    public double getTaxesPaid() {
        return taxesPaid;
    }

    public String getStationName() {
        return stationName;
    }

    public String getStationLocation() {
        return stationLocation;
    }

    public Double getGallonPurchased() {
        return gallonPurchased;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public String getComment() {
        return comment;
    }

    public void setTripNo(String tripNo) {
        this.tripNo = tripNo;
    }

    public void setDriverNo(String driverNo) {
        this.driverNo = driverNo;
    }

    public void setCoDriverNo(String coDriverNo) {
        this.coDriverNo = coDriverNo;
    }

    public void setTruckNo(String truckNo) {
        this.truckNo = truckNo;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public void setMilesDriven(int milesDriven) {
        this.milesDriven = milesDriven;
    }

    public void setFuelReceiptNumber(String fuelReceiptNumber) {
        this.fuelReceiptNumber = fuelReceiptNumber;
    }

    public void setFuelPaid(double fuelPaid) {
        this.fuelPaid = fuelPaid;
    }

    public void setTaxesPaid(double taxesPaid) {
        this.taxesPaid = taxesPaid;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setStationLocation(String stationLocation) {
        this.stationLocation = stationLocation;
    }

    public void setGallonPurchased(Double gallonPurchased) {
        this.gallonPurchased = gallonPurchased;
    }

    public void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
