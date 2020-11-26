package model;

import util.DbConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Truck {
    private String truckNo;
    private String truckBrand;

    public Truck() {
    }

    public static Truck getTruck(String truckNo) {
        try {
            // Create truck
            Truck truck = new Truck();

            // Execute sql
            ResultSet rs = DbConn.getConn().prepareStatement("select * from Truck where truckNo = '" + truckNo + "'").executeQuery();

            // Fill out trip
            rs.next();
            truck = rsToTruck(rs);

            return truck;
        } catch (SQLException e) {
            return null;
        }
    }

    public static List<Truck> getAllTruck() {
        try {
            // Create list
            List<Truck> trucks = new ArrayList<Truck>();

            // Execute sql
            ResultSet rs = DbConn.getConn().prepareStatement("select * from Truck").executeQuery();

            // Fill out list
            while(rs.next()){
                trucks.add(rsToTruck(rs));
            }

            return trucks;
        } catch (SQLException e) {
            return null;
        }
    }

    private static Truck rsToTruck(ResultSet rs) throws SQLException {
        Truck truck = new Truck();

        truck.truckNo = rs.getString("truckNo");
        truck.truckBrand = rs.getString("truckBrand");

        return truck;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "truckNo='" + truckNo + '\'' +
                ", truckBrand='" + truckBrand + '\'' +
                '}';
    }

    public String getTruckNo() {
        return truckNo;
    }

    public String getTruckBrand() {
        return truckBrand;
    }
}
