package ro.ase.acs.adapter;

public class LowCostFlightBooking {
    private String[][] places;
    public static final int NO_ROWS = 20;
    public static final int NO_SEATS_PER_ROW = 6;

    public LowCostFlightBooking() {
        this.places = new String[20][6];
        for(int i=0; i<NO_ROWS; i++){
            for(int j=0; j<NO_SEATS_PER_ROW; j++){
                this.places[i][j] = "O";
            }
        }
    }
    public void reserveSeat(){
        boolean found=false;
        for(int i=0; i<NO_ROWS; i++) {
            for(int j=0; j<NO_SEATS_PER_ROW; j++) {
                if(places[i][j].equals("O")){
                    places[i][j] = "X";
                    found=true;
                    break;
                }

            }
            if(found){
                break;
            }
        }
    }
    public void seatMap(){
        for(int i=0; i<NO_SEATS_PER_ROW; i++){
            for(int j=0; j<NO_ROWS; j++){
                System.out.print(places[j][i]);
                System.out.print(" ");
            }
            if(i == 1){
                System.out.println();
                System.out.println("<");
            }
            System.out.println();
        }
    }
}
