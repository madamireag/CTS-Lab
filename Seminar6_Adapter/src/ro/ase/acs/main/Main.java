package ro.ase.acs.main;

import ro.ase.acs.adapter.*;

public class Main {
    public static void main(String[] args) {
        FlightBooking flightBooking = new FlightBooking();
        flightBooking.addBooking(2,'B');
        flightBooking.addBooking(2,'C');
        flightBooking.displaySeats();
        System.out.println();
        LowCostFlightBooking lowCostFlightBooking = new LowCostFlightBooking();
        lowCostFlightBooking.reserveSeat();
        lowCostFlightBooking.reserveSeat();
        lowCostFlightBooking.seatMap();

        System.out.println();
        FlightBooking booking = new LowCostToFlightBookingAdapter(lowCostFlightBooking);
        booking.addBooking(2,'B');
        booking.addBooking(2,'C');
        booking.displaySeats();

        System.out.println();
        AbstractFlightBooking classBooking = new LowCostToFlightBookingClassAdapter();
        classBooking.addBooking(2,'B');
        classBooking.addBooking(2,'C');
        classBooking.displaySeats();
    }
}
