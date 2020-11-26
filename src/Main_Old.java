import model.Driver;
import model.Trip;
import util.DbConn;

public class Main_Old {

    public static void main(String[] args) {
        System.out.println("----- ----- ----- ----- ----- -----");
        System.out.println("----- ----- Trip Report ----- -----");
        System.out.println("");

        // Connect to database
        DbConn.connect();


//        for(Trip trip : Trip.getAllTrip())
//            System.out.println(trip.toString());

//        System.out.println(Trip.getTrip(4));

//        for (Driver driver : Driver.getAllDriver())
//            System.out.println(driver.toString());

//        System.out.println(Driver.getDriver("GO7013553"));

        Trip.saveTrip(Trip.getTrip(3));
    }
}