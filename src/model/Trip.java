package model;

import util.DbConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
            while(rs.next()){
                trips.add(rsToTrip(rs));
            }

            return trips;
        } catch (SQLException e) {
            return null;
        }
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
                ", stateCode=" + stateCode +
                ", departDate=" + departDate +
                ", returnDate=" + returnDate +
                ", milesDriven=" + milesDriven +
                ", fuelReceiptNumber='" + fuelReceiptNumber + '\'' +
                ", fuelPaid=" + fuelPaid +
                ", taxesPaid=" + taxesPaid +
                ", stationName='" + stationName + '\'' +
                ", stationLocation='" + stationLocation + '\'' +
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

    public String getComment() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setComment(String comment) {
        this.comment = comment;
    }
}
