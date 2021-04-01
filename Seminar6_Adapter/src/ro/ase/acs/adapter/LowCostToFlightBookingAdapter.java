package ro.ase.acs.adapter;

public class LowCostToFlightBookingAdapter extends FlightBooking{
    // Adapter de obiecte - has a cu obiectul adaptat si is a cu cel catre care adaptez
    // adapterul trebuie sa fie de tip FlightBooking, la final vreau un FlightBooking deci din el derivez
    private LowCostFlightBooking lowCostFlightBooking;

    public LowCostToFlightBookingAdapter(LowCostFlightBooking lowCostFlightBooking){
        this.lowCostFlightBooking = lowCostFlightBooking;
    }

    @Override
    public boolean addBooking(int row, char seat) {
         lowCostFlightBooking.reserveSeat();
         return true;
    }

    @Override
    public void displaySeats() {
     lowCostFlightBooking.seatMap();
    }
}
