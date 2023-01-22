package kata_5_bd;
import java.io.File;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kata_5_bd {

    public static void main(String[] args) throws SQLException  {
        FlightStore store = new SQLiteFlightStore(new File("flights.db"));
        List<Flight> flightCancelled = new ArrayList<>();
        for(Flight flight: store.iterable()){
            if (flight.isCancelled() == true){
                flightCancelled.add(flight);
            }
            /***
            System.out.println(flight.getDayofweek() + " " + flight.getDepartureTime() + " " + 
                               flight.getDepartureDelay() + " " + flight.getArrivalTime() + " " + 
                               flight.getArrivalDelay() + " " + flight.isCancelled() + " " + 
                               flight.isDiverted() + " " + flight.getDuration() + " " + flight.getDistance());
            System.out.println("DayOfTheFlight: " + flight.getDayofweek() + " " + 
                               "Distance: " + flight.getDistance() + " " +
                               "Duration: " + flight.getDuration()+ " " +
                               "¿IsCancelled?: " + flight.isCancelled());
            **/
        }
        
        System.out.println("Flight Cancelled: " + flightCancelled.size());

        /***
        for (Flight flight : flightCancelled) {
            System.out.println(flight.getDayofweek() + " " + flight.getDepartureTime() + " " +
                               flight.getArrivalTime() + " " + flight.isCancelled() + " " + flight.getDistance());
        }
        ***/
        
        
        
    }
    
}
