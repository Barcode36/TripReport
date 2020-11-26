package model;

import util.DbConn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Driver {
    private String driverNo;
    private String driverName;
    private String phoneNo;

    public Driver() {
    }

    public static Driver getDriver(String driverNo) {
        try {
            // Create trip
            Driver driver = new Driver();

            // Execute sql
            ResultSet rs = DbConn.getConn().prepareStatement("select * from Driver where driverNo = '" + driverNo + "'").executeQuery();

            // Fill out trip
            rs.next();
            driver = rsToDriver(rs);

            return driver;
        } catch (SQLException e) {
            return null;
        }
    }

    public static List<Driver> getAllDriver() {
        try {
            // Create list
            List<Driver> drivers = new ArrayList<Driver>();

            // Execute sql
            ResultSet rs = DbConn.getConn().prepareStatement("select * from Driver").executeQuery();

            // Fill out list
            while(rs.next()){
                drivers.add(rsToDriver(rs));
            }

            return drivers;
        } catch (SQLException e) {
            return null;
        }
    }

    private static Driver rsToDriver(ResultSet rs) throws SQLException {
        Driver driver = new Driver();

        driver.driverNo = rs.getString("driverNo");
        driver.driverName = rs.getString("driverName");
        driver.phoneNo = rs.getString("phoneNo");

        return driver;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverNo='" + driverNo + '\'' +
                ", driverName='" + driverName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }

    public String getDriverNo() {
        return driverNo;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setDriverNo(String driverNo) {
        this.driverNo = driverNo;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
