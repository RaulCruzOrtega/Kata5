package kata_5_bd;

import java.io.File;
import java.util.Iterator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import static java.util.Collections.emptyIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLiteFlightStore implements FlightStore {
    private final File file;
    private final Connection connection;
    


    public SQLiteFlightStore(File file) throws SQLException {
        this.file = file;
        this.connection = DriverManager.getConnection("jdbc:sqlite:"+ file.getAbsolutePath());
    }
    
    @Override
    public Iterable<Flight> iterable() {
        return new Iterable<Flight>() {
            @Override
            public Iterator<Flight> iterator() {
                try {
                    return create_iterator();
                } catch (SQLException ex) {
                    return emptyIterator();
                }
            }
        };
    }
    
    private Iterator<Flight> create_iterator() throws SQLException{
        ResultSet rs = connection.createStatement().executeQuery("SELECT * FROM flights");
        return new Iterator<Flight>() {
            Flight nextFlight = nextFlight(rs);
            @Override
            public boolean hasNext() {
                return nextFlight != null; 
            }

            @Override
            public Flight next() {
                Flight flight = nextFlight;
                try {
                    nextFlight = nextFlight(rs);
                } catch (SQLException ex) {
                }
                return flight;
            }

        };
    }
    
    private Flight nextFlight(ResultSet rs) throws SQLException {
        if (!next(rs)) return null;
        return new Flight(
        DayOfWeek.of(rs.getInt("DAY_OF_WEEK")),
        timeOf(rs.getInt("DEP_TIME")),
        rs.getInt("DEP_DELAY"),
        timeOf(rs.getInt("ARR_TIME")),
        rs.getInt("ARR_DELAY"),
        rs.getInt("AIR_TIME"),
        rs.getInt("DISTANCE"),
        rs.getInt("CANCELLED") == 1,
        rs.getInt("DIVERTED") == 1
        );
    }
    
    private LocalTime timeOf(int d) {
        return LocalTime.of(d / 100 % 24, d%100);
    }

    private boolean next(ResultSet rs){
        try{
            boolean next = rs.next();
            if(next) return true;
        }catch(SQLException ex){
        }
        return false;
    }
}
