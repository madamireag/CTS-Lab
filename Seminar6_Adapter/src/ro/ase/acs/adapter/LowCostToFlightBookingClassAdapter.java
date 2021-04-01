package ro.ase.acs.adapter;

public class LowCostToFlightBookingClassAdapter extends LowCostFlightBooking implements AbstractFlightBooking{
    // in relatie de derivare extends catre obiectul adaptat
    // obiectul catre care vreau sa adaptez am relatie implements (interfata)
    @Override
    public boolean addBooking(int row, char seat) {
        super.reserveSeat();
        return true;
    }

    @Override
    public void displaySeats() {
        super.seatMap();
    }


}
