package ro.ase.acs.models;

import java.util.Scanner;

public class Atm implements IAtm {
    Scanner scanner = new Scanner(System.in);

    @Override
    public float transaction() {
        System.out.println("Apasati 1 pentru retragere sau 2 pentru depunere");
        String key = scanner.nextLine();
        boolean isRetragere = false;
        if (key.equals("1")) {
            isRetragere = true;
        } else if (key.equals("2")) {
            isRetragere = false;
        }
        System.out.println("Introduceti suma");
        float value = Float.valueOf(scanner.nextLine());
        if (isRetragere) {
            return -value;
        } else {
            return value;
        }
    }
}
