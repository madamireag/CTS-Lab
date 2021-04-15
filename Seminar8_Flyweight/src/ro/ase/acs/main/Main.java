package ro.ase.acs.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char key = 0;
        int x = 0;
        int y = 0;
        Scanner scanner = new Scanner(System.in);
        while (key != '^') {
            x++;
            if(x > 10) {
                y++;
                x = 0;
            }
            key = scanner.next().charAt(0);
            CustomCharacter customCharacter = CharacterFactory.getCharacter(key);
            customCharacter.display(new Location(x,y));
            // Example - ce se intampla cand schimb starea permanenta
            ((CustomFontCharacter) customCharacter).setFont("Times New Roman");

        }

    }
}
