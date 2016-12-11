package database;

/**
 * Created by Oleksandr on 05.12.2016.
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class DB {
    private static DB instance = null;
    private Hashtable<Integer, Booking> bookings = new Hashtable<Integer, Booking>();

    public DB(){

    }

    public static DB getInstance() {
        if (instance == null)
            instance = new DB();
        return instance;
    }


    public ArrayList<Booking> getAllBookings(){
        return new ArrayList<Booking>(bookings.values());

    }

    public void addBooking(Booking booking){
        booking.setId(bookings.size());
        bookings.put(booking.getId(),booking);
    }

    public boolean updateBooking(Booking booking){
    	if(!bookings.containsKey(booking.getId()))
    		return false;
        bookings.put(booking.getId(),booking);
        return true;
    }

    public Booking getBooking(int id) {
    	System.out.println(id);
    	if(!bookings.containsKey(id))
    		return null;
        return bookings.get(id);
    }

    public boolean removeBooking(int id){
    	if(bookings.containsKey(id)){
    		bookings.remove(id);
    		return true;
    	}
    	return false;
    }

}
