package services;

import database.Booking;
import database.DB;
import database.Person;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by Oleksandr on 05.12.2016.
 */
@WebService
public class FlightOrderService {
    DB db;

    public FlightOrderService(){
    	db = new DB();
    }
    
    public List<Booking> getBookings(){
        return db.getAllBookings();
    }

    public boolean addBooking(String name, String startAirport, String endAirport, String depTime, String arrTime){
        Booking booking = new Booking();
        Person person = new Person(name);
        booking.setPerson(person);
        booking.setDeparture(startAirport,depTime);
        booking.setArrival(endAirport,arrTime);
        db.addBooking(booking);
        return true;
    }


    public boolean updateBooking(int id, String name, String startAirport, String endAirport, String depTime, String arrTime){
    	Booking booking = db.getBooking(id);
    	if(booking == null)
    		return false;
        Person person = new Person(name);
        booking.setPerson(person);
        booking.setDeparture(startAirport,depTime);
        booking.setArrival(endAirport,arrTime);
        db.addBooking(booking);
        return true;
    }

    public boolean removeBooking(int id){
        return db.removeBooking(id);
    }
}
