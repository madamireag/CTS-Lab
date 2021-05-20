package ro.ase.acs.main;

import ro.ase.acs.template.LunchTemplate;
import ro.ase.acs.template.RomanianCuisineLunch;

public class Main {
    public static void main(String[] args) {
        LunchTemplate lunchTemplate = new RomanianCuisineLunch();
        lunchTemplate.takeLunch();

    }
}
