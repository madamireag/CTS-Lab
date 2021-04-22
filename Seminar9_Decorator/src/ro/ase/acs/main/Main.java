package ro.ase.acs.main;

import ro.ase.acs.decorator.Car;
import ro.ase.acs.decorator.Vehicle;
import ro.ase.acs.decorator.VehicleWithAlarm;
import ro.ase.acs.decorator.VehicleWithParkingSensors;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("red",300,4);
        car.start();
        car.stop();

        //Vehicle carWithAlarm = new VehicleWithAlarm(car);  // asa nu pot sa accesez metoda suplimentara
        VehicleWithAlarm carWithAlarm = new VehicleWithAlarm(car);
        carWithAlarm.start();
        carWithAlarm.stop();

        Vehicle carWithParkingSensors = new VehicleWithParkingSensors(car,5);
        carWithParkingSensors.start();
        carWithParkingSensors.stop();

        // Cum verific ca am implementat corect? - se accepta mai multe decorari

        Vehicle carWithAlarmAndParkingSensors = new VehicleWithParkingSensors(new VehicleWithAlarm(car),4);
        carWithAlarmAndParkingSensors.start();
        carWithAlarmAndParkingSensors.stop();

    }
}
